// import org.junit.Test;
// import src.main.java.Graph;
import com.example.Graph;
// import demo.src.main.java.com.example.Graph;
// import org.junit.jupiter.api.Test;
// import static org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;

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
        

        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(0).add(3);
        ArrayList<Integer> result = Graph.bfsOfGraph(V, adj);

        assertArrayEquals("BFS failed for a simple connected graph.",Arrays.asList(0, 1, 3, 2).toArray(), result.toArray());
    }

    @Test 
    public void dfsOfGraphTest(){{
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
        
        assertArrayEquals("DFS failed for a simple connected graph.",Arrays.asList(0, 1,2,3).toArray(), result.toArray());
        
    }
}
}
