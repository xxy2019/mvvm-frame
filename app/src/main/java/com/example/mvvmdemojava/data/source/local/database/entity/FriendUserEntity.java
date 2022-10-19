package com.example.mvvmdemojava.data.source.local.database.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "friend_user")
public class FriendUserEntity {

    @PrimaryKey
    private long id;

    //用户名称，一般是用户登录时的用户名
    private String username;

    //用户类型，包括用户、机器人、部分用户（还不是好友，只发送了申请，前端自定义【apply/operate/refused】）等
    private String userType;

    //用户头像，一般存储的都是网络图片路径
    private String avatarUrl;

    //用户昵称，支持用户更改
    private String nickname;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
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

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", userType='" + userType + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
