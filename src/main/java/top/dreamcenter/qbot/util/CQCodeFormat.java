package top.dreamcenter.qbot.util;


/**
 * 转化成CQ Code格式
 */
public class CQCodeFormat {

    public static String format(String type, String parameters) {
        return "[CQ:" + type + parameters + "]";
    }
}
