package top.dreamcenter.qbot.entity.reply;

import lombok.Data;

/**
 * 语音回复
 * <p> <b>注意！需要 ffmpeg支持</b>
 */
@Data
@Deprecated
public abstract class RecordReply extends Reply{

    /**
     * 语音文件名称
     */
    private String file;

    /**
     * 是否变声
     * <p>  - 0 不变
     * <p>  - 1 变
     */
    private Byte magic = 0;

}
