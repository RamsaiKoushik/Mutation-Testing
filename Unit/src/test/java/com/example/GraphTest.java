package com.example;
import java.beans.Transient;
import java.lang.annotation.Target;
import java.util.Comparator;
import java.util.Collections;
// import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// import src.main.java.com.example.Graph;
// import java.awt.desktop.ScreenSleepEvent.main
// import java.awt.desktop.ScreenSleepEvent.

// import src.main.java.com.example.GraphUnit;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GraphTest {
    public static void main(String[] args) {
        Graph graph = new Graph();
    }


    @Test
    public void bfsOfGraphTest(){   
        // ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        // adj.add(new ArrayList<Integer>(Arrays.asList(1, 2)));
        // adj.add(new ArrayList<Integer>(Arrays.asList(2, 3)));
        System.out.println("Hello There");

        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(0).add(3);
        ArrayList<Integer> result = Graph.bfsOfGraph(V, adj);

        assertEquals("BFS failed for a simple connected graph.",Arrays.asList(0, 1, 3, 2), result);
    }

    @Test 
    public void dfsOfGraphTest(){
        // assertEquals();
        // assert
        int V = 4;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        // adj.get(3).add(2);
        
        List<Integer> result = Graph.dfsOfGraph(V, adj);
        
        assertArrayEquals("DFS failed for a simple connected graph.",Arrays.asList(0,1,2,3).toArray(), result.toArray());
        
    }


    @Test
    public void findProvincesTest(){
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        int result = Graph.findProvinces(isConnected);
        assertEquals("Failed to find provinces in a graph.",2, result);
    }

    @Test
    public void isCycleTest(){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        // adj.add(new ArrayList<Integer>(Arrays.asList(1, 2)));
        for (int i = 0; i < 4; i++) adj.add(new ArrayList<>());
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        // adj.add(new ArrayList<Integer>(Arrays.asList(2, 3)));
        boolean result = Graph.isCycle(adj);
        assertEquals("Failed to find cycle in a graph.",false, result);
    }

    @Test 
    public void isCycleTest2(){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 3; i++) adj.add(new ArrayList<>());
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(0);
        boolean result = Graph.isCycle(adj);
        assertEquals("Failed to find cycle in a graph.",true, result);
    }

    @Test
    public void isCycledfsTest(){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) adj.add(new ArrayList<>());
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        boolean result = Graph.isCycledfs(adj);
        assertEquals("Failed to find cycle in a graph.",false, result);
    }

    @Test 
    public void isCycledfsTest2(){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 3; i++) adj.add(new ArrayList<>());
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(0);
        boolean result = Graph.isCycledfs(adj);
        assertEquals("Failed to find cycle in a graph.",true, result);
    }

    @Test
    public void orangesRottingTest(){
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}}; 
        int result = Graph.orangesRotting(grid);
        assertEquals(4, result);
    }

    @Test
    public void solveTest(){
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        Graph.solve(board);
        char[][] expected = {{'X','X','X','X'},{'X','X','X','X'},{'X','X','X','X'},{'X','O','X','X'}};
        assertArrayEquals(expected, board);
    }

    @Test
    public void WordladderLengthTest(){
        List<String> dict = Arrays.asList("hot","dot","dog","lot","log","cog");
        String beginWord = "hit";
        String endWord = "cog";
        int result = Graph.WordladderLength(beginWord, endWord, dict);
        assertEquals(5, result);
    }

    @Test
    public void updateMatrixTest(){
        int[][] matrix = {{0,0,0},{0,1,0},{1,1,1}};
        int[][] result = Graph.updateMatrix(matrix);
        int[][] expected = {{0,0,0},{0,1,0},{1,2,1}};
        assertArrayEquals(expected, result);
    }

    // @Test
    // public void isBipartiteTest(){
    //     ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    //     // for (int i = 0; i < 4; i++) adj.add(new ArrayList<>());
    //     // adj.get(0).add(1);
    //     // adj.get(1).add(2);
    //     // adj.get(2).add(3);
    //     // adj.get(0).add(3);
    //     // int [][] arr = {};
    //     // add 1 to zeroth array
    //     adj.add(new ArrayList<Integer>(Arrays.asList(1)));
    //     adj.add(new ArrayList<Integer>(Arrays.asList(2)));
    //     adj.add(new ArrayList<Integer>(Arrays.asList(3)));
    //     adj.add(new ArrayList<Integer>(Arrays.asList(0)));
    //     // adj.add(new ArrayList<Integer>(Arrays.asList(3)));        
    //     boolean result = Graph.isBipartite(adj);
    //     assertEquals(true, result);
    // }

    @Test
    public void isCycleTest3(){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) adj.add(new ArrayList<>());
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(0);
        boolean result = Graph.isCycle(4,adj);
        assertEquals(true, result);
    }

    @Test
    public void isCycleTest4(){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) adj.add(new ArrayList<>());
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        // adj.get(3).add(1);
        boolean result = Graph.isCycle(4,adj);
        assertEquals(false, result);
    }


    @Test
    public void eventualSafeNodesTest(){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 7; i++) adj.add(new ArrayList<>());
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(2);
        adj.get(1).add(3);
        adj.get(2).add(5);
        adj.get(3).add(0);
        adj.get(4).add(5);

        List<Integer> result = Graph.eventualSafeNodes(adj);
        List<Integer> expected = Arrays.asList(2,4,5,6);
        assertArrayEquals(expected.toArray(), result.toArray());
    }


    @Test
    public void shortestPathBinaryMatrixTest(){
        int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
        int result = Graph.shortestPathBinaryMatrix(grid);
        assertEquals(4, result);
    }


    @Test
    public void findCheapestPriceTest(){
        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int result = Graph.findCheapestPrice(4, flights, 0, 3, 1);
        assertEquals(700, result);  
    }

    @Test
    public void minimumEffortPathTest(){
        int[][] heights = {{1,2,2},{3,8,2},{5,3,5}}; 
        int result = Graph.minimumEffortPath(heights);
        assertEquals(2, result);
    }

    @Test
    public void networkDelayTimeTest(){
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int result = Graph.networkDelayTime(times, 4, 2);
        assertEquals(2, result);
    }

    @Test
    public void countPathsTest(){
        int n = 7;
        int[][] roads = {{0,6,7},
        {0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},
        {4,6,2},{6,5,1},{2,5,1},{0,4,5}};
        int result = Graph.countPaths(n, roads);
        assertEquals(4, result);
    }


    @Test
    public void findTheCityTest(){
        int n = 4;
        int[][] edges = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
        int distanceThreshold = 4;
        int result = Graph.findTheCity(n, edges, distanceThreshold);
        assertEquals(3, result);
    }

    @Test
    public void makeConnectedTest(){
        int n = 6;
        int[][] connections = {{0,1},{0,2},{0,3},{1,2},{1,3}};
        int result = Graph.makeConnected(n, connections);
        assertEquals(2, result);
    }  

    @Test
    public void AccountsMergeTest() {
        // Input example from LeetCode
        List<List<String>> accounts = Arrays.asList(
            Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
            Arrays.asList("John", "johnnybravo@mail.com"),
            Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
            Arrays.asList("Mary", "mary@mail.com")
        );

        // Expected output
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("John", "john00@mail.com", "john_newyork@mail.com", "johnsmith@mail.com"),
            Arrays.asList("John", "johnnybravo@mail.com"),
            Arrays.asList("Mary", "mary@mail.com")
        );

        // Sort each list in the expected and result to ensure order doesn't cause test failure
        expected.forEach(Collections::sort);

        // Call the method to test
        List<List<String>> result = Graph.accountsMerge(accounts);

        // Sort each list in the result
        result.forEach(Collections::sort);

        // Sort the outer lists as well to ensure the correct order of accounts
        expected.sort(Comparator.comparing(a -> a.get(0)));
        result.sort(Comparator.comparing(a -> a.get(0)));

        // Assert that the result matches the expected output
        assertEquals(expected, result);
    }












}
