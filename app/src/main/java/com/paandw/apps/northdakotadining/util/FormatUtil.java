package com.paandw.apps.northdakotadining.util;

public class FormatUtil {
    public static String stripHTML(String htmlString){
         return htmlString.replaceAll("<[^<>]+>([^<>]*)<[^<>]+>", "").replaceAll("&nbsp;", "").replaceAll(" +", " ");
    }
}
