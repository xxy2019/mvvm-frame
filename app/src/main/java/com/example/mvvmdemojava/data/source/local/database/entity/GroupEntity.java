package com.example.mvvmdemojava.data.source.local.database.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "group_chat")
public class GroupEntity {

    @PrimaryKey
    private long id;

    //群聊名称
    private String groupName;

    //群聊头像，一般存储的都是网络图片路径
    private String avatarUrl;

    //群聊昵称
    private String nickname;

    //群聊成员数量
    private int memberNumber;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getMemberNumber() {
        return memberNumber;
    }

    public void setMemberNumber(int memberNumber) {
        this.memberNumber = memberNumber;
    }

    @Override
    public String toString() {
        return "GroupEntity{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", nickname='" + nickname + '\'' +
                ", memberNumber=" + memberNumber +
                '}';
    }
}
