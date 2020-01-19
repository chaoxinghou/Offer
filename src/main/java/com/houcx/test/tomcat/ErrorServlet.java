package com.houcx.test.tomcat;

import java.io.IOException;

public class ErrorServlet extends MyServlet {
    public void doGet(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.weite("404...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void doPost(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.weite("404...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
