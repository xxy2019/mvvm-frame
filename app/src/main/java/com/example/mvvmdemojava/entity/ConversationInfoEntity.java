package com.example.mvvmdemojava.entity;

public class ConversationInfoEntity {

    //会话id，如果是单聊，则存储userId，如果是群聊，存储groupId
    private long id;

    //会话类型，分为单聊/群聊（single/group）
    private String type;

    //会话中未读的消息数量
    private int unreadMsgCount;

    //会话是否置顶
    private Boolean isTopping;

    //会话中最后一条消息的消息类型
    private String lastMsgAction;

    //会话中最后一条消息的id
    private long lastMsgTime;

    //会话中最后一条消息的消息内容
    private String lastMsgContent;

    //会话昵称
    private String nickname;

    //会话名称
    private String conversationName;

    //会话头像
    private String avatarUrl;

    //会话的成员数量
    private int memberNumber;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getUnreadMsgCount() {
        return unreadMsgCount;
    }

    public void setUnreadMsgCount(int unreadMsgCount) {
        this.unreadMsgCount = unreadMsgCount;
    }

    public Boolean getTopping() {
        return isTopping;
    }

    public void setTopping(Boolean topping) {
        isTopping = topping;
    }

    public String getLastMsgAction() {
        return lastMsgAction;
    }

    public void setLastMsgAction(String lastMsgAction) {
        this.lastMsgAction = lastMsgAction;
    }

    public long getLastMsgTime() {
        return lastMsgTime;
    }

    public void setLastMsgTime(long lastMsgTime) {
        this.lastMsgTime = lastMsgTime;
    }

    public String getLastMsgContent() {
        return lastMsgContent;
    }

    public void setLastMsgContent(String lastMsgContent) {
        this.lastMsgContent = lastMsgContent;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setConversationName(String conversationName) {
        this.conversationName = conversationName;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public void setMemberNumber(int memberNumber) {
        this.memberNumber = memberNumber;
    }

    public String getNickname() {
        return nickname;
    }

    public String getConversationName() {
        return conversationName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public int getMemberNumber() {
        return memberNumber;
    }

    @Override
    public String toString() {
        return "ConversationInfoEntity{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", unreadMsgCount=" + unreadMsgCount +
                ", isTopping=" + isTopping +
                ", lastMsgAction='" + lastMsgAction + '\'' +
                ", lastMsgTime=" + lastMsgTime +
                ", lastMsgContent='" + lastMsgContent + '\'' +
                ", nickName='" + nickname + '\'' +
                ", conversationName='" + conversationName + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", memberNumber=" + memberNumber +
                '}';
    }
}
