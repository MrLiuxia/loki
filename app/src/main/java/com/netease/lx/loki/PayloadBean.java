package com.netease.lx.loki;

/**
 * Description:
 * Author: liuxiao
 * Data: 2019-08-08
 *
 * @blame: liuxiao
 */
public class PayloadBean {

    private String content;
    private String id;
    private String title;
    private String style;
    private String interest;
    private String skipId;
    private String msgId;
    private String skipType;
    private String type;
    private String skip;
    private String pushType;
    private String bigImageUrl;

    public static PayloadBean demoBean() {
        PayloadBean bean = new PayloadBean();
        bean.setContent("要说谋财害命，谁也比不上地方电视台的假药广告");
        bean.setId("CQ2DK4VB00018M4D");
        bean.setTitle("为什么地方电视台都是假药广告？");
        bean.setStyle("1");
        bean.setInterest("");
        bean.setSkip("CQ2DK4VB00018M4D");
        bean.setMsgId("0b933db989a04310b5507414c1de466f");
        bean.setBigImageUrl("");
        bean.setSkipType("docid");
        bean.setType("0");
        bean.setSkip("docid\u003dCQ2DK4VB00018M4D");
        bean.setPushType("doc");
        return bean;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getSkipId() {
        return skipId;
    }

    public void setSkipId(String skipId) {
        this.skipId = skipId;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getSkipType() {
        return skipType;
    }

    public void setSkipType(String skipType) {
        this.skipType = skipType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSkip() {
        return skip;
    }

    public void setSkip(String skip) {
        this.skip = skip;
    }

    public String getPushType() {
        return pushType;
    }

    public void setPushType(String pushType) {
        this.pushType = pushType;
    }

    public String getBigImageUrl() {
        return bigImageUrl;
    }

    public void setBigImageUrl(String bigImageUrl) {
        this.bigImageUrl = bigImageUrl;
    }
}
