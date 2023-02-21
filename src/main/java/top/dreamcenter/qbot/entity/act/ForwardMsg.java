package top.dreamcenter.qbot.entity.act;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class ForwardMsg {
    private List<BasicMsg> messages;
}
