package top.dreamcenter.qbot.util;

import org.springframework.core.ParameterizedTypeReference;
import top.dreamcenter.qbot.entity.RetResult;
import top.dreamcenter.qbot.entity.account.Account;
import top.dreamcenter.qbot.entity.act.*;

import java.util.List;

/**
 * 类型参考转换器 ParameterizedTypeReference
 */
public class PTR {
    public static ParameterizedTypeReference<RetResult<Object>> empty() {
        return new ParameterizedTypeReference<RetResult<Object>>() {};
    }

    public static ParameterizedTypeReference<RetResult<Account>> account() {
        return new ParameterizedTypeReference<RetResult<Account>>() {};
    }

    public static ParameterizedTypeReference<RetResult<Group>> group() {
        return new ParameterizedTypeReference<RetResult<Group>>() {};
    }

    public static ParameterizedTypeReference<RetResult<List<Group>>> groups() {
        return new ParameterizedTypeReference<RetResult<List<Group>>>() {};
    }

    public static ParameterizedTypeReference<RetResult<GroupMember>> groupMember() {
        return new ParameterizedTypeReference<RetResult<GroupMember>>() {};
    }

    public static ParameterizedTypeReference<RetResult<List<GroupMember>>> groupMembers() {
        return new ParameterizedTypeReference<RetResult<List<GroupMember>>>() {};
    }

    public static ParameterizedTypeReference<RetResult<List<Friend>>> friends() {
        return new ParameterizedTypeReference<RetResult<List<Friend>>>() {};
    }

    public static ParameterizedTypeReference<RetResult<Stranger>> stranger() {
        return new ParameterizedTypeReference<RetResult<Stranger>>() {};
    }

    public static ParameterizedTypeReference<RetResult<MessageID>> messageID() {
        return new ParameterizedTypeReference<RetResult<MessageID>>() {};
    }

    public static ParameterizedTypeReference<RetResult<ResMessage>> resMessage() {
        return new ParameterizedTypeReference<RetResult<ResMessage>>() {};
    }

    public static ParameterizedTypeReference<RetResult<ForwardMsg>> forwardMsg() {
        return new ParameterizedTypeReference<RetResult<ForwardMsg>>() {};
    }

    public static ParameterizedTypeReference<RetResult<ResImage>> resImage() {
        return new ParameterizedTypeReference<RetResult<ResImage>>() {};
    }
}
