package top.dreamcenter.qbot.entity.reply;

import lombok.Data;

/**
 * 语音
 * <p>发送方得到的消息，即该类封装了已经得到的消息（好像没用）
 */
@Data
@Deprecated
public class RecordSenderReply extends RecordReply{
    /**
     * 只在通过网络 URL 发送时有效, 表示是否使用已缓存的文件
     * <p>  - 0 不使用
     * <p>  - 1 使用
     */
    private Byte cache = 1;

    /**
     * 只在通过网络 URL 发送时有效, 表示是否通过代理下载文件 ( 需通过环境变量或配置文件配置代理 )
     * <p>  - 0 不使用
     * <p>  - 1 使用
     */
    private Byte proxy = 1;

    /**
     * 只在通过网络 URL 发送时有效, 单位秒, 表示下载网络文件的超时时间 , 默认不超时
     */
    private Integer timeout = null;

    public RecordSenderReply(String file) {
        setFile(file);
    }

    @Override
    public String toString() {
        // [CQ:record,file=http://baidu.com/1.mp3]
        return "[CQ:record" +
                ",file=" + getFile() +
                ",magic=" + getMagic() +
                ",cache=" + cache +
                ",proxy=" + proxy +
                ( timeout == null ? "" : "timeout=" + timeout ) +
                "]";
    }
}
