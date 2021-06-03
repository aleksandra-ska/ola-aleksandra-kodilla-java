package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        Forum forum = new Forum();

        Map<Integer, ForumUser> theResultUsers = forum.getList().stream()
                .filter(s -> s.getSex() == 'M')
                .filter(s -> s.getBirthDate().getYear() < 2001)
                .filter(s -> s.getPostsCount() >= 1)
                .collect(Collectors.toMap(ForumUser::getIdentificator, forumUser -> forumUser));

        System.out.println("# elements: " + theResultUsers.size());             // [2]
        theResultUsers.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())                   // [3]
                .forEach(System.out::println);
    }
}
