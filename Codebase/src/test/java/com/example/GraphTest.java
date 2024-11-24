package com.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
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

    // @Test
    // public void isCycledfsTest(){
    //     ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    //     for (int i = 0; i < 4; i++) adj.add(new ArrayList<>());
    //     adj.get(0).add(1);
    //     adj.get(1).add(2);
    //     adj.get(2).add(3);
    //     boolean result = Graph.isCycledfs(adj);
    //     assertEquals("Failed to find cycle in a graph.",false, result);
    // }

    // @Test 
    // public void isCycledfsTest2(){
    //     ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    //     for (int i = 0; i < 3; i++) adj.add(new ArrayList<>());
    //     adj.get(0).add(1);
    //     adj.get(1).add(2);
    //     adj.get(2).add(0);
    //     boolean result = Graph.isCycledfs(adj);
    //     assertEquals("Failed to find cycle in a graph.",true, result);
    // }

    @Test
    public void orangesRottingTest(){
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}}; 
        int result = Graph.orangesRotting(grid);
        assertEquals(4, result);
    }

    @Test
    public void surroundedRegionsTest(){
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        Graph.surroundedRegions(board);
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

    @Test
    public void testIsBipartiteTrue() {
        // Test Case 1: Bipartite Graph (Should return true)
        int[][] graph = {
            {1, 3},
            {0, 2},
            {1, 3},
            {0, 2}
        };
        assertTrue("The graph should be bipartite", Graph.isBipartite(graph));
    }

    @Test
    public void testIsBipartiteFalse() {
        // Test Case 2: Non-Bipartite Graph (Should return false)
        int[][] graph = {
            {1, 2, 3},
            {0, 2},
            {0, 1, 3},
            {0, 2}
        };
        assertFalse("The graph should not be bipartite", Graph.isBipartite(graph));
    }

    @Test
    public void testFindOrder() {
        // Test case 1: Valid order
        int numCourses1 = 4;
        int[][] prerequisites1 = {
            {1, 0},
            {2, 0},
            {3, 1},
            {3, 2}
        };
        int[] result1 = Graph.findOrder(numCourses1, prerequisites1);
        assertTrue(isValidOrder(result1, numCourses1, prerequisites1));

        // Test case 2: Impossible to complete all courses
        int numCourses2 = 2;
        int[][] prerequisites2 = {
            {1, 0},
            {0, 1}
        };
        int[] result2 = Graph.findOrder(numCourses2, prerequisites2);
        assertArrayEquals(new int[0], result2);

        // Test case 3: No prerequisites
        int numCourses3 = 3;
        int[][] prerequisites3 = {};
        int[] result3 = Graph.findOrder(numCourses3, prerequisites3);
        assertEquals(3, result3.length);

        // Test case 4: Single course
        int numCourses4 = 1;
        int[][] prerequisites4 = {};
        int[] result4 = Graph.findOrder(numCourses4, prerequisites4);
        assertArrayEquals(new int[]{0}, result4);

        // Test case 5: All courses independent
        int numCourses5 = 3;
        int[][] prerequisites5 = {
            {1, 0},
            {2, 0}
        };
        int[] result5 = Graph.findOrder(numCourses5, prerequisites5);
        assertTrue(isValidOrder(result5, numCourses5, prerequisites5));
    }

    // Helper method to validate the topological order
    private boolean isValidOrder(int[] order, int numCourses, int[][] prerequisites) {
        if (order.length != numCourses) {
            return false;
        }

        Map<Integer, Integer> position = new HashMap<>();
        for (int i = 0; i < order.length; i++) {
            position.put(order[i], i);
        }

        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int prereqCourse = prereq[1];
            if (position.get(prereqCourse) > position.get(course)) {
                return false;
            }
        }

        return true;
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
    public void testBellmanFord() {
        int V = 5;
        List<int[]> edges = new ArrayList<>();
        edges.add(new int[]{0, 1, -1});
        edges.add(new int[]{0, 2, 4});
        edges.add(new int[]{1, 2, 3});
        edges.add(new int[]{1, 3, 2});
        edges.add(new int[]{1, 4, 2});
        edges.add(new int[]{3, 2, 5});
        edges.add(new int[]{3, 1, 1});
        edges.add(new int[]{4, 3, -3});

        int S = 0;

        List<Integer> expectedDistances = Arrays.asList(0, -1, 2, -2, 1);
        List<Integer> result = Graph.bellmanFord(V, edges, S);

        assertEquals(expectedDistances, result);

        // Test case for negative-weight cycle
        edges.add(new int[]{3, 0, -8}); // Adding a negative cycle
        List<Integer> resultWithCycle = Graph.bellmanFord(V, edges, S);
        assertEquals(Arrays.asList(-1), resultWithCycle); // Should return -1 indicating a negative cycle
    }

    // @Test
    // public void makeConnectedTest(){
    //     int n = 6;
    //     int[][] connections = {{0,1},{0,2},{0,3},{1,2},{1,3}};
    //     int result = Graph.countConnected(n, connections);
    //     assertEquals(2, result);
    // }  

    @Test
    public void testcountConnected() {
        // Test case 1: Multiple connected components
        int n1 = 6;
        int[][] edges1 = {
            {0, 1},
            {1, 2},
            {3, 4}
        };
        int expected1 = 3; // Three connected components: {0,1,2}, {3,4}, {5}
        assertEquals(expected1, Graph.countConnected(n1, edges1));

        // Test case 2: Fully connected graph
        int n2 = 4;
        int[][] edges2 = {
            {0, 1},
            {1, 2},
            {2, 3}
        };
        int expected2 = 1; // One connected component
        assertEquals(expected2, Graph.countConnected(n2, edges2));

        // Test case 3: Disconnected graph with no edges
        int n3 = 5;
        int[][] edges3 = {};
        int expected3 = 5; // Five connected components, as there are no edges
        assertEquals(expected3, Graph.countConnected(n3, edges3));

        // Test case 4: Single node
        int n4 = 1;
        int[][] edges4 = {};
        int expected4 = 1; // Single connected component with just one node
        assertEquals(expected4, Graph.countConnected(n4, edges4));

        // Test case 5: Edge cases with duplicate edges
        int n5 = 4;
        int[][] edges5 = {
            {0, 1},
            {1, 2},
            {2, 0}, // Cycle, but still one connected component
            {3, 3}  // Self-loop
        };
        int expected5 = 2; // Two connected components: {0,1,2}, {3}
        assertEquals(expected5, Graph.countConnected(n5, edges5));
    }

    @Test
    public void testAccountsMerge() {
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        accounts.add(Arrays.asList("John", "johnnybravo@mail.com"));
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        accounts.add(Arrays.asList("Mary", "mary@mail.com"));

        List<List<String>> expected = Arrays.asList(
            Arrays.asList("John", "john00@mail.com", "john_newyork@mail.com", "johnsmith@mail.com"),
            Arrays.asList("John", "johnnybravo@mail.com"),
            Arrays.asList("Mary", "mary@mail.com")
        );

        List<List<String>> result = Graph.accountsMerge(accounts);

        // Convert to Set for comparison as order in lists may differ
        Set<Set<String>> expectedSet = new HashSet<>();
        for (List<String> group : expected) {
            expectedSet.add(new HashSet<>(group));
        }

        Set<Set<String>> resultSet = new HashSet<>();
        for (List<String> group : result) {
            resultSet.add(new HashSet<>(group));
        }

        assertEquals(expectedSet, resultSet);
    }

    @Test
    public void testFindRedundantConnection() {
        int[][] edges1 = {{1, 2}, {1, 3}, {2, 3}};
        int[] expected1 = {2, 3};
        assertArrayEquals(expected1, Graph.findRedundantConnection(edges1));

        int[][] edges2 = {{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}};
        int[] expected2 = {4, 1};
        assertArrayEquals(expected2, Graph.findRedundantConnection(edges2));
    }

    @Test
    public void testLargestIsland() {
        int[][] grid1 = {
            {1, 0},
            {0, 1}
        };
        assertEquals(3, Graph.largestIsland(grid1));

        int[][] grid2 = {
            {1, 1},
            {1, 0}
        };
        assertEquals(4, Graph.largestIsland(grid2));

        int[][] grid3 = {
            {1, 1},
            {1, 1}
        };
        assertEquals(4, Graph.largestIsland(grid3));
    }


    @Test
    public void loudAndRichtest() {
        int[][] richer = {
            {1, 0},
            {2, 1},
            {3, 1},
            {3, 7},
            {4, 3},
            {5, 3},
            {6, 3}
        };
        // 
        ArrayList<Integer> quiet = new ArrayList<>(Arrays.asList(3, 2, 5, 4, 6, 1, 7, 0));
        // assertEquals(5, Graph.loudAndRich(richer, quiet));
        ArrayList<Integer> ans = new ArrayList<>(Arrays.asList(5, 5, 2, 5, 4, 5, 6, 7));
        assertEquals(ans, Graph.loudAndRich(richer, quiet));
    }


    @Test
    public void testGetAncestors() {
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(),
            Arrays.asList(0),
            Arrays.asList(0),
            Arrays.asList(0),
            Arrays.asList(0, 1)
        );
        List<List<Integer>> result = Graph.getAncestors(5, edges);
        assertEquals(expected, result);
    }
}
