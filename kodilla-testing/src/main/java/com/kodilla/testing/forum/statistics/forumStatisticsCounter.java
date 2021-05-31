package com.kodilla.testing.forum.statistics;

public class forumStatisticsCounter {

    int usersCount = 0;
    int postsCount = 0;
    int commentsCount = 0;
    double averagePostsCount = 0;
    double averageCommentsCount = 0;
    double averageCommentsCountPerPostsCount = 0;

    public int getUsersCount() {
        return usersCount;
    }

    public int getPostsCount() {
        return postsCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public double getAveragePostsCount() {
        return averagePostsCount;
    }

    public double getAverageCommentsCount() {
        return averageCommentsCount;
    }

    public double getAverageCommentsCountPerPostsCount() {
        return averageCommentsCountPerPostsCount;
    }

    public void calculateAdvStatistics(Statistics statistics) {

        usersCount = statistics.usersNames().size();
        postsCount = statistics.postsCount();
        commentsCount = statistics.commentsCount();

        if (usersCount > 0) {
            averagePostsCount = (double) postsCount / (double) usersCount;
            averageCommentsCount = (double) commentsCount / (double) usersCount;
        }
        if (postsCount > 0) {
            averageCommentsCountPerPostsCount = (double) commentsCount / (double) postsCount;
        }
    }

    public void showStatistisc() {
        System.out.println("Number of users: " + usersCount);
        System.out.println("Number of posts: " + postsCount);
        System.out.println("Number of comments: " + commentsCount);
        System.out.println("Average number of posts per user: " + averagePostsCount);
        System.out.println("Average number of comments per user: " + averageCommentsCount);
        System.out.println("Average number of comments per post: " + averageCommentsCountPerPostsCount);

    }
}
