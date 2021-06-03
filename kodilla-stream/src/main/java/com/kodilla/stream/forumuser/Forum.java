package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {

    private final List<ForumUser> userList = new ArrayList<>();

    public Forum() {
        userList.add(new ForumUser(01, "Travis", 'M', LocalDate.of(2004, 12, 22), 57));
        userList.add(new ForumUser(02, "Scot", 'M', LocalDate.of(2000, 4, 15), 10));
        userList.add(new ForumUser(03, "Jane", 'F', LocalDate.of(2001, 9, 13), 0));
        userList.add(new ForumUser(04, "Ken", 'M', LocalDate.of(2005, 10, 22), 5));
        userList.add(new ForumUser(05, "Diana", 'F', LocalDate.of(2000, 12, 15), 12));
        userList.add(new ForumUser(06, "Taylor", 'M', LocalDate.of(1999, 12, 3), 0));

    }

    public List<ForumUser> getList() {
        return new ArrayList<>(userList);
    }
}
