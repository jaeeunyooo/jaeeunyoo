package com.jaeeunyoo.blog.util;

import org.jsoup.Jsoup;

public class HtmlUtil {

    public static String htmlToText(String html) {
        return html != null && !html.isEmpty() ? Jsoup.parse(html).text() : "";
    }
}
