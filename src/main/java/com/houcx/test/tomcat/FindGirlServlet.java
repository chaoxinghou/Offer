package com.houcx.test.tomcat;

import java.io.IOException;

public class FindGirlServlet extends MyServlet {
    public void doGet(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.weite("get girl...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void doPost(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.weite("post girl...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
