package cn.mq.demo.design.proxy.staticproxy;

import cn.mq.demo.design.proxy.PeopleTalk;

/**
 * Created by qiangzi on 16/6/13.
 */
public class TestProxy {

    public static void main(String[] args) {
        ProxyTalk proxyTalk = new ProxyTalk(new PeopleTalk("李宇春"));
        proxyTalk.talk("周杰伦");
    }
}
