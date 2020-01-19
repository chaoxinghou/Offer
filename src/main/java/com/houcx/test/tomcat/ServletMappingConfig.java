package com.houcx.test.tomcat;

import java.util.ArrayList;
import java.util.List;

public class ServletMappingConfig {
    public static List<ServletMapping> servletMappingList = new ArrayList();

    static {
        servletMappingList.add(new ServletMapping("找对象", "/girl", "com.houcx.test.tomcat.FindGirlServlet"));
    }
}
