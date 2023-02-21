# qbot

关键词 : go-cqhttp, springboot, 脚手架

利用go-cqhttp的反向http渠道，搭建了springboot框架下的qq机器人工程架构。

工程性质是脚手架，已经完成了整体的架构，只需要编写实际业务即可。

目前工程已经实现了go-cqhttp的 
“消息上报” 解析、
CQ码回复、
部分API便捷调用。

对于“通知上报”、“请求上报”、“元事件上报”
几个内容还没有实现解析处理，后续的开发中会逐个进行实现。
技术水平够的话也可以自行在 RootController.distribute 方法
中进行解析处理。

# 架构

1. [go-cqhttp](https://github.com/Mrs4s/go-cqhttp)

2. springboot

# 使用方式

创建一个MessageService的实现类实现业务逻辑的编写，
可以参考MessageServiceExampleImpl这个样例实现类理解。

_该MessageService接口 包含了两个方法，
一个是私聊消息函数，一个是群消息函数。_

MessageController 将收到所有消息上报，
并且将消息实体传递到Service业务逻辑层进行处理，
我们可以对消息相应操作后进行回复Reply
（如果return null，将不会进行回复）。

### 基础配置

#### go-cqhttp

设置config.yml中的服务列表如下

```yml
# 连接服务列表
servers:
  - http: # HTTP 通信设置
      address: 0.0.0.0:5700 # HTTP监听地址
      timeout: 5      # 反向 HTTP 超时时间, 单位秒，<5 时将被忽略
      long-polling:   # 长轮询拓展
        enabled: false       # 是否开启
        max-queue-size: 2000 # 消息队列大小，0 表示不限制队列大小，谨慎使用
      middlewares:
        <<: *default # 引用默认中间件
      post:           # 反向HTTP POST地址列表
      - url: http://127.0.0.1:5701/  # 地址
      #  secret: ''                  # 密钥
        max-retries: 3               # 最大重试，0 时禁用
        retries-interval: 1500       # 重试时间，单位毫秒，0 时立即
```

#### springboot

application.yml如下配置

```yml
dreamcenter:
  serverAddr: http://127.0.0.1:5701    # springboot工程服务地址
  botServerAddr: http://127.0.0.1:5700 # go-cqhttp工程服务地址
```


### 回复的消息

回复的消息除了文本消息 **Reply(String)** ，还可以携带 **CQ码** ，
来进行复杂类型消息回复，如 _@某人、发送图片_ 等。

各种类型的回复消息在 **entity.reply** 包下展现，
其中一些 **过时的类** 代表的含义是个人测试为无效CQ码。

回复的消息并非总是单独的一个CQ码或者纯文本，有时候是整合成了一个复杂的语句发送，
我提供了 **ReplyLink** 类进行连接处理，
比如我们想要发送 " **@xxx 你好** "，可以如下表示

```text
return ReplyLink.getInstance()
        .append(new AtReply("1981669259"))
        .append(new Reply(" 你好"))
        .link();
```

我们的MessageService中函数返回的类型是Reply，是所有xxxReply的基类。

### 主动发送消息 & 管理

上面的方法及controller是主动接受消息、被动发消息的模式，在收到消息之后，触发回复。

但是有时候我们想要在某个特别的时间点主动推送消息，比如每日整点新闻等。

又或者想要主动管理群和好友等，那么需要主动请求cqhttp的API。

当然我这里封装了大部分常用的API请求在 **active** 包下，
**xxxACT** 都是注册到spring容器的，
所以使用的地方只要 **@Autowired** 引入相应的 xxxACT 即可，
后续直接使用该act中的函数 来实现相关内容的主动推送。

MsgACT : 与消息相关的主动调用

GroupManageACT : 与群管理相关的主动调用

AccountManageACT : 与账户管理相关的主动调用

FileManageACT : 与文件管理相关的主动调用 _(暂未实现)_

还有一些用的概率不大的API，诸位可以自行编写调用官方API。
当然也欢迎push来帮助我这个框架更加完整。

**如果想要定时发送，可以自行编写springboot的schedule定时任务。**

### 其它

架构中的其它细节内容可以不用去关心，只需要关注xxxACT和xxxReply即可。

对于一些实体通过名字还是比较容易理解的，
如果对于该实体的某个成员变量意义不明，
一方面可以查看go-cqhttp的文档查看，
也可以直接 **ctrl+左键** 查看该类的属性注释，
该注释内容实际上基本都是CV的cqhttp文档内容。

# 更多

### 联系 & push

可以通过邮箱1981669259@qq.com进行初步联系，如果我个人觉得有探讨的必要，
会申请好友添加。

对于push请求，只要不影响正常的主体逻辑，都是有可能被采纳的，
如果能理解框架实现原理后统一风格开发那就更高兴啦。

如果是增值服务push，比如一些util的封装、某个平台的api对接模块、
一些api资源(天气、查题...)的调用等等，全部放到plugin包中，并且
子包以你的github用户名命名，不符合规则的一律ignore。

### 嘿嘿嘿

如果觉得不错的话，感谢点一个star收藏。

如果能够投喂什么的，当然更开心啦！

<p>
  <img src="https://dreamcenter.github.io/FeedMe/wx.jpg" height="400px"/>
  <img src="https://dreamcenter.github.io/FeedMe/zfb.jpg" height="400px"/>
</p>

<br/>

bye ~
