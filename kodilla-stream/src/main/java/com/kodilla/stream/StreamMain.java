package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.YEARS;

public class StreamMain {
    public static void main(String[] args) {
        Forum forum = new Forum();

        Map<Integer, ForumUser> theResultUsers = forum.getList().stream()
                .filter(s -> s.getSex() == 'M')
                .filter(s -> YEARS.between(s.getBirthDate(), LocalDate.now()) >= 20)
                .filter(s -> s.getPostsCount() >= 1)
                .collect(Collectors.toMap(ForumUser::getIdentificator, forumUser -> forumUser));

        System.out.println("# elements: " + theResultUsers.size());
        theResultUsers.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }
}
