package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

public class ForumDirectoryTestSuite {
    public static int testCounter = 0;

    @BeforeEach
    public void beforeAll() {
        testCounter++;
        System.out.println("Test#" + testCounter);
    }

    private Statistics statisticsMock;

    @Test
    void testStatisticsOf0Posts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        forumStatisticsCounter statisticsCounter = new forumStatisticsCounter();

        //When
        statisticsCounter.calculateAdvStatistics(statisticsMock);
        statisticsCounter.showStatistisc();

        //Then
        Assertions.assertEquals(0, statisticsCounter.getPostsCount());
    }

    @Test
    void testStatisticsOf1000Posts() {
        //Given
        Statistics statistics = mock(Statistics.class);
        forumStatisticsCounter statisticsCounter = new forumStatisticsCounter();
        when(statistics.postsCount()).thenReturn(1000);

        //When
        statisticsCounter.calculateAdvStatistics(statistics);

        //Then
        Assertions.assertEquals(1000, statisticsCounter.getPostsCount());
    }

    @Test
    void testStatisticsOf0Comments() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        forumStatisticsCounter statisticsCounter = new forumStatisticsCounter();

        //When
        statisticsCounter.calculateAdvStatistics(statisticsMock);
        statisticsCounter.showStatistisc();

        //Then
        Assertions.assertEquals(0, statisticsCounter.getCommentsCount());
    }
    @Test
    void testCalculateAdvStatisticsWhenCommentsCountIsLowerThanPostsCount() {
        //Given
        Statistics statistics = mock(Statistics.class);
        forumStatisticsCounter statisticsCounter = new forumStatisticsCounter();
        ArrayList<String> users = new ArrayList<String>();
        for(int i = 0; i < 50; i++) {
            users.add("user" + i);
        }
        when(statistics.usersNames()).thenReturn(users);
        when(statistics.postsCount()).thenReturn(200);
        when(statistics.commentsCount()).thenReturn(100);

        //When
        statisticsCounter.calculateAdvStatistics(statistics);
        statisticsCounter.showStatistisc();

        //Then
        Assertions.assertEquals(50, statisticsCounter.getUsersCount());
        Assertions.assertEquals(200, statisticsCounter.getPostsCount());
        Assertions.assertEquals(100, statisticsCounter.getCommentsCount());
        Assertions.assertEquals(4, statisticsCounter.getAveragePostsCount());
        Assertions.assertEquals(2, statisticsCounter.getAverageCommentsCount());
        Assertions.assertTrue(statisticsCounter.getAverageCommentsCountPerPostsCount() < 1);
    }

    @Test
    void testCalculateAdvStatisticsWhenCommentsCountIsHigherThanPostCount() {
        //Given
        Statistics statistics = mock(Statistics.class);
        forumStatisticsCounter statisticsCounter = new forumStatisticsCounter();
        ArrayList<String> users = new ArrayList<String>();
        for(int i = 0; i < 50; i++) {
            users.add("user" + i);
        }
        when(statistics.usersNames()).thenReturn(users);
        when(statistics.postsCount()).thenReturn(100);
        when(statistics.commentsCount()).thenReturn(200);

        //When
        statisticsCounter.calculateAdvStatistics(statistics);
        statisticsCounter.showStatistisc();

        //Then
        Assertions.assertEquals(50, statisticsCounter.getUsersCount());
        Assertions.assertEquals(100, statisticsCounter.getPostsCount());
        Assertions.assertEquals(200, statisticsCounter.getCommentsCount());
        Assertions.assertEquals(2, statisticsCounter.getAveragePostsCount());
        Assertions.assertEquals(4, statisticsCounter.getAverageCommentsCount());
        Assertions.assertTrue(statisticsCounter.getAverageCommentsCountPerPostsCount() > 1);
    }

    @Test
    void testStatisticsOf0User() {
        //
        Statistics statistics = mock(Statistics.class);
        forumStatisticsCounter statisticsCounter = new forumStatisticsCounter();

        //When
        statisticsCounter.calculateAdvStatistics(statistics);
        statisticsCounter.showStatistisc();

        //Then
        Assertions.assertEquals(0, statisticsCounter.getUsersCount());
    }

    @Test
    void testStatisticsOf100Users() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        forumStatisticsCounter statisticsCounter = new forumStatisticsCounter();
        ArrayList<String> users = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            users.add("user" + i);
        }
        when(statisticsMock.usersNames()).thenReturn(users);

        //When
        statisticsCounter.calculateAdvStatistics(statisticsMock);
        statisticsCounter.showStatistisc();

        //Then
        Assertions.assertEquals(100, statisticsCounter.getUsersCount());
    }
}
