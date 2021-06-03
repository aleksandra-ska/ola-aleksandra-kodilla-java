package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {

    private final int identificator;
    private final String userName;
    private final char sex;
    private final LocalDate birthDate;
    private final int postsCount;

    public ForumUser(int identificator, String userName, char sex, LocalDate birthDate, int postsCount) {
        this.identificator = identificator;
        this.userName = userName;
        this.sex = sex;
        this.birthDate = birthDate;
        this.postsCount = postsCount;
    }

    public int getIdentificator() {
        return identificator;
    }

    public String getUserName() {
        return userName;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPostsCount() {
        return postsCount;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "identificator=" + identificator +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", birthDate=" + birthDate +
                ", postsCount=" + postsCount +
                '}';
    }
}
