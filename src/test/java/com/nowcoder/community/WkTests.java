package com.nowcoder.community;

import java.io.IOException;

public class WkTests {
    public static void main(String[] args) {
        String cmd = "E:/JavaWeb/wkhtmltopdf/bin/wkhtmltopdf https://www.nowcoder.com/tutorial/10014/59ea263a0c6a4b9fae045ee676a49e5a D:/JaveWebCommunity/data/wk-pdf/1.pdf";
        try {
            Runtime.getRuntime().exec(cmd);
            System.out.println("ok!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
