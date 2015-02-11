package guda.red.biz.taobao;

import com.taobao.api.internal.tmc.Message;
import com.taobao.api.internal.tmc.MessageHandler;
import com.taobao.api.internal.tmc.MessageStatus;
import com.taobao.api.internal.tmc.TmcClient;
import com.taobao.top.link.LinkException;

/**
 * Created by foodoon on 2015/2/8.
 */
public class TaobaoMsgHandler  {

    public void startListener() throws LinkException {

        TmcClient client = new TmcClient("app_key", "app_secret","default");
        client.setMessageHandler(new MessageHandler() {
            public void onMessage(Message message, MessageStatus status) {
                try {
                    System.out.println(message.getContent());
                    System.out.println(message.getTopic());
                    // 默认不抛出异常则认为消息处理成功
                } catch (Exception e) {
                    e.printStackTrace();
                    status.fail();// 消息处理失败回滚，服务端需要重发
                }
            }
        });
        client.connect();

    }
}
