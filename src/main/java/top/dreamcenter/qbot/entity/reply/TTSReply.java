package top.dreamcenter.qbot.entity.reply;

import lombok.Data;
import top.dreamcenter.qbot.util.KVString;

/**
 * 文字转语音
 * <p>通过TX的TTS接口, 采用的音源与登录账号的性别有关</p>
 * <p>范围: 仅群聊</p>
 */
@Data
public class TTSReply extends Reply{

    /**
     * 内容
     */
    private String text;

    public TTSReply(String text) {
        this.text = text;
    }

    @Override
    public String toString(){
        return KVString.builder()
                .put("text", text)
                .toQRCode("tts");
    }
}
