package io.jiantao.statistics.lib;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author jiantao
 * @date 2018/4/6
 */
public class DefaultHttpStackImpl implements HttpStack<String> {

    @Override
    public boolean syncData(String jsonData) {
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(Statistic.get().getApi());
            urlConnection = createConnection(url);
            OutputStream outputStream = new BufferedOutputStream(urlConnection.getOutputStream());
            outputStream.write(jsonData.getBytes("utf-8"));
            outputStream.flush();

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                // 内存流对象
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = in.read(buffer)) != -1) {
                    byteArrayOutputStream.write(buffer, 0, len);
                }
                String result = new String(byteArrayOutputStream.toByteArray(), "utf-8");
                try {
                    JSONObject jobj = new JSONObject(result);
                    int code = jobj.optInt("errcode");
                    // code == 0 表示请求成功
                    return code == 0;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
        return false;
    }


    /**
     * Create an {@link HttpURLConnection} for the specified {@code url}.
     */
    protected HttpURLConnection createConnection(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

    /**
     * Opens an {@link HttpURLConnection} with parameters.
     *
     * @param url
     * @return an open connection
     * @throws IOException
     */
    private HttpURLConnection openConnection(URL url) throws IOException {
        HttpURLConnection connection = createConnection(url);

        final int timeoutMs = 10_1000;
        connection.setConnectTimeout(timeoutMs);
        connection.setReadTimeout(timeoutMs);
        connection.setUseCaches(false);
        connection.setDoInput(true);
        connection.setChunkedStreamingMode(0);
        connection.setInstanceFollowRedirects(false);

        connection.setRequestMethod("POST");
        connection.addRequestProperty("Content-type", "application/json");

        return connection;
    }


}
