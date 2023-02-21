package top.dreamcenter.qbot.active;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.dreamcenter.qbot.entity.PackServer;

/**
 * 与文件相关的操作
 */
@Component
public class FileManageACT {
    @Autowired
    private PackServer packServer;

}
