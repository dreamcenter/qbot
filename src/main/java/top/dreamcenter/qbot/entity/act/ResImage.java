package top.dreamcenter.qbot.entity.act;

import lombok.Data;

/**
 * 获取到的图片
 */
@Data
public class ResImage {

    /**
     * 图片大小
     */
    private Integer size;

    /**
     * 图片文件原名
     */
    private String filename;

    /**
     * 图片下载地址
     */
    private String url;
}
