package com.houcx.test.tomcat;

import java.io.IOException;
import java.io.InputStream;

public class MyRequest {
    private String url;
    private String method;
    private byte[] httpRequestBytes = new byte[1024];

    public MyRequest(InputStream inputStream) throws IOException {
        //        GET /girl112 HTTP/1.1
        //        Host: localhost:8080
        //        Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
        //        Upgrade-Insecure-Requests: 1
        //        Cookie: _ga=GA1.1.635523823.1519349691; Idea-98300ac4=0375c4fb-918a-4b81-a023-f1b7fc0e107d
        //        User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_3) AppleWebKit/604.5.6 (KHTML, like Gecko) Version/11.0.3 Safari/604.5.6
        //        Accept-Language: zh-cn
        //        Accept-Encoding: gzip, deflate
        //        Connection: keep-alive
        String httpRequest = "";
        int length;
        if ((length = inputStream.read(httpRequestBytes)) > 0) {
            httpRequest = new String(httpRequestBytes, 0, length);
        }

        String httpHead = httpRequest.split("\n")[0];
        url = httpHead.split("\\s")[1];
        method = httpHead.split("\\s")[0];
        System.out.println(this);
    }

    public String getUrl() {
        return url;
    }

    public String getMethod() {
        return method;
    }

    @Override
    public String toString() {
        return "MyRequest{" +
                "url='" + url + '\'' +
                ", method='" + method + '\'' +
                '}';
    }
}
