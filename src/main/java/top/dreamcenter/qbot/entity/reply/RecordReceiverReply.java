package top.dreamcenter.qbot.entity.reply;

import lombok.Data;

/**
 * 语音
 * <p>接收方拟返回的消息，即该类封装了即将返回的消息（好像没用）
 */
@Data
@Deprecated
public class RecordReceiverReply extends RecordReply{
    /**
     * 语音url
     */
    private String url;


    public RecordReceiverReply(String file, String url) {
        setFile(file);
        this.url = url;
    }

    @Override
    public String toString() {
        return "[CQ:record" +
                ",file=" + getFile() +
                ",magic=" + getMagic() +
                ",url=" + url +
                "]";
    }
}
