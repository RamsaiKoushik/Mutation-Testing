package com.example;
import java.util.*;
// import java.util.LinkedList;
public class Graph {
    // public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) 
    // { // https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
    //     ArrayList<Integer> result = new ArrayList<>();
    //     boolean[] visited = new boolean[V]; // To keep track of visited nodes
    //     Queue<Integer> queue = new LinkedList<>(); // Queue for BFS

    //     // Start BFS from the first node (node 0)
    //     queue.add(0);
    //     visited[0] = true;

    //     while (!queue.isEmpty()) 
    //     {
    //         int current = queue.poll();
    //         result.add(current);

    //         // Visit all the neighbors of the current node
    //         for (int neighbor : adj.get(current)) 
    //         {
    //             if (!visited[neighbor]) 
    //             {
    //                 queue.add(neighbor);
    //                 visited[neighbor] = true;
    //             }
    //         }
    //     }
    //     return result;
    // }

    // public static void dfs(int node, List<List<Integer>> adj, boolean[] visited, List<Integer> result) 
    // {
    //     for (int neighbor : adj.get(node)) 
    //     {
    //         if (!visited[neighbor]) 
    //         {
    //             visited[neighbor] = true;
    //             result.add(neighbor);
    //             dfs(neighbor, adj, visited, result);
    //         }
    //     }
    // }

    // // Function to return a list containing the DFS traversal of the graph.
    // public static List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) 
    // { //https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
    //     boolean[] visited = new boolean[V]; 
    //     List<Integer> result = new ArrayList<>();

    //     // Assuming the graph is connected and starting DFS from node 0
    //     visited[0] = true;
    //     result.add(0);
    //     dfs(0, adj, visited, result);

    //     return result;
    // }

    public static void dfs_province(int node, int[][] isConnected, boolean[] visit) 
    {
        visit[node] = true;
        for (int i = 0; i < isConnected.length; i++)
         {
            if (isConnected[node][i] == 1 && !visit[i]) 
            {
                dfs_province(i, isConnected, visit);
            }
        }
    }
    
    public static int findProvinces(int[][] isConnected) 
    { //https://leetcode.com/problems/number-of-provinces/
        int n = isConnected.length;
        int numberOfComponents = 0;
        boolean[] visit = new boolean[n];

        for (int i = 0; i < n; i++) 
        {
            if (!visit[i])
            {
                numberOfComponents++;
                dfs_province(i, isConnected, visit);
            }
        }

        return numberOfComponents;
    }

    // public static boolean isCycle(ArrayList<ArrayList<Integer>> adj) 
    // { //https://leetcode.com/problems/course-schedule/
    //     boolean[] vis = new boolean[adj.size()];
    //     for(int i =0; i < adj.size();i++)
    //     {
    //         if(!vis[i])
    //         {
    //             if(help(adj,vis,i,-1))
    //             {
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }
    // public static boolean help(ArrayList<ArrayList<Integer>> adj,boolean[] vis,int curr,int parent)
    // {
    //     vis[curr] = true;
    //     for(int nei : adj.get(curr))
    //     {
    //         if(!vis[nei])
    //         {
    //             if(help(adj,vis,nei,curr))
    //             {
    //                 return true;
    //             }
    //         }
    //         else if(vis[nei] && nei!=parent)
    //         {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    // public static boolean isCycledfs(ArrayList<ArrayList<Integer>> adj) 
    // { // https://leetcode.com/problems/course-schedule/
    //     boolean[] vis = new boolean[adj.size()];
    //     for(int i =0; i < adj.size();i++)
    //     {
    //         if(!vis[i])
    //         {
    //             if(helpisCycledfs(adj,vis,i,-1))
    //             {
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }
    // public static boolean helpisCycledfs(ArrayList<ArrayList<Integer>> adj,boolean[] vis,int curr,int parent)
    // {
    //     vis[curr] = true;
    //     for(int nei : adj.get(curr))
    //     {
    //         if(!vis[nei])
    //         {
    //             if(help(adj,vis,nei,curr))
    //             {
    //                 return true;
    //             }
    //         }
    //         else if(vis[nei] && nei!=parent)
    //         {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    // public static int orangesRotting(int[][] grid) 
    // { // https://leetcode.com/problems/rotting-oranges/
    //     Queue<int[]> q = new LinkedList<>();
    //     for (int i = 0; i < grid.length; i++) 
    //     {
    //         for (int j = 0; j < grid[i].length; j++) 
    //         {
    //             if (grid[i][j] == 2) 
    //             {
    //                 q.add(new int[]{i, j});
    //             }
    //         }
    //     }

    //     int[] dx = {0, 0, -1, 1};
    //     int[] dy = {1, -1, 0, 0};
    //     int minutes = 0;

    //     while (!q.isEmpty())
    //     {
    //         int sz = q.size();
    //         while (sz-- > 0) 
    //         {
    //             int[] current = q.poll();
    //             for (int i = 0; i < 4; i++) 
    //             {
    //                 int nx = current[0] + dx[i];
    //                 int ny = current[1] + dy[i];
    //                 if (nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length && grid[nx][ny] == 1) 
    //                 {
    //                     q.add(new int[]{nx, ny});
    //                     grid[nx][ny] = 2;
    //                 }
    //             }
    //         }
    //         minutes++;
    //     }

    //     for (int i = 0; i < grid.length; i++) 
    //     {
    //         for (int j = 0; j < grid[i].length; j++) 
    //         {
    //             if (grid[i][j] == 1) {
    //                 return -1;
    //             }
    //         }
    //     }

    //     return minutes == 0 ? 0 : minutes - 1;
    // }


    // public static void dfs(char[][] board, int i, int j) 
    // {
    //     int m = board.length;
    //     int n = board[0].length;
    //     int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    //     board[i][j] = 'Y';
    //     for (int[] d : dir) 
    //     {
    //         int ix = i + d[0];
    //         int jy = j + d[1];
    //         if (ix > 0 && ix < m - 1 && jy > 0 && jy < n - 1 && board[ix][jy] == 'O') 
    //         {
    //             dfs(board, ix, jy);
    //         }
    //     }
    // }
    // public static void solve(char[][] board) 
    // { // https://leetcode.com/problems/surrounded-regions/
    //     int m = board.length;
    //     if (m == 0) return;
    //     int n = board[0].length;
    //     // Traverse borders to find 'O's
    //     for (int i = 0; i < m; ++i) 
    //     {
    //         for (int j = 0; j < n; ++j) 
    //         {
    //             if (i == 0 || i == m - 1 || j == 0 || j == n - 1) 
    //             {
    //                 if (board[i][j] == 'O') 
    //                 {
    //                     dfs(board, i, j);
    //                 }
    //             }
    //         }
    //     }
    //     // Replace all 'O's with 'X's
    //     for (int i = 0; i < m; ++i) 
    //     {
    //         for (int j = 0; j < n; ++j) 
    //         {
    //             if (board[i][j] == 'O')
    //             { 
    //                 board[i][j] = 'X';
    //             }
    //         }
    //     }
    //     // Replace all 'Y's back to 'O's
    //     for (int i = 0; i < m; ++i) {
    //         for (int j = 0; j < n; ++j) 
    //         {
    //             if (board[i][j] == 'Y')
    //             {
    //                  board[i][j] = 'O';
    //             }
    //         }
    //     }
    // }

    // public static int WordladderLength(String beginWord, String endWord, List<String> wordList)
    // { // https://leetcode.com/problems/word-ladder/
    //     Set<String> set = new HashSet<>(wordList);
    //     if(!set.contains(endWord)) return 0;
        
    //     Queue<String> queue = new LinkedList<>();
    //     queue.add(beginWord);
        
    //     Set<String> visited = new HashSet<>();
    //     queue.add(beginWord);
        
    //     int changes = 1;
        
    //     while(!queue.isEmpty())
    //     {
    //         int size = queue.size();
    //         for(int i = 0; i < size; i++)
    //         {
    //             String word = queue.poll();
    //             if(word.equals(endWord))
    //             { 
    //                 return changes;
    //             }
    //             for(int j = 0; j < word.length(); j++)
    //             {
    //                 for(int k = 'a'; k <= 'z'; k++)
    //                 {
    //                     char arr[] = word.toCharArray();
    //                     arr[j] = (char) k;
                        
    //                     String str = new String(arr);
    //                     if(set.contains(str) && !visited.contains(str))
    //                     {
    //                         queue.add(str);
    //                         visited.add(str);
    //                     }
    //                 }
    //             }
    //         }
    //         ++changes;
    //     }
    //     return 0;
    // }

    // public static int[][] updateMatrix(int[][] mat) 
    // { //https://leetcode.com/problems/01-matrix/
    //     int rows = mat.length;
    //     int cols = mat[0].length;
    //     int[][] distances = new int[rows][cols];
    //     boolean[][] visited = new boolean[rows][cols];
    //     Queue<int[]> q = new LinkedList<>();
        
    //     for (int i = 0; i < rows; i++) 
    //     {
    //         for (int j = 0; j < cols; j++) 
    //         {
    //             if (mat[i][j] == 0)
    //             {
    //                 q.add(new int[]{0, i, j}); // {distance, row, col}
    //                 visited[i][j] = true;
    //             } 
    //             else 
    //             {
    //                 distances[i][j] = Integer.MAX_VALUE;
    //             }
    //         }
    //     }

    //     int[] dx = {1, -1, 0, 0};
    //     int[] dy = {0, 0, -1, 1};

    //     while (!q.isEmpty()) 
    //     {
    //         int[] current = q.poll();
    //         int distance = current[0];
    //         int x = current[1];
    //         int y = current[2];
    //         distances[x][y] = distance;

    //         for (int i = 0; i < 4; i++) 
    //         {
    //             int nx = x + dx[i];
    //             int ny = y + dy[i];
    //             if (nx >= 0 && ny >= 0 && nx < rows && ny < cols && !visited[nx][ny]) 
    //             {
    //                 visited[nx][ny] = true;
    //                 q.add(new int[]{distance + 1, nx, ny});
    //             }
    //         }
    //     }

    //     return distances;
    // }
    
    // public static boolean isBipartite(int[][] graph) 
    // { //https://leetcode.com/problems/is-graph-bipartite/
    //     int[] colors = new int[graph.length];
    //     Arrays.fill(colors, -1);
    //     for(int u = 0; u < graph.length; u++)
    //     {
    //         if(colors[u] == -1)
    //         {
    //             if(!dfs(u, graph, colors, 1))
    //             {
    //                 return false;
    //             }
    //         }
    //     }
    //     return true;
    // }
    
    // public static boolean dfs(int u, int[][]graph, int[]colors, int col)
    // {
    //     if (colors[u] == 1 - col)
    //     {
    //         return false; 
    //     } 
    //     if (colors[u] == col)
    //     {
    //         return true; 
    //     }
    //     colors[u] = col;
    //     for (var neighbor: graph[u])
    //     {
    //         if (!dfs(neighbor, graph, colors, 1 - col))
    //         {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    // public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    // { //https://leetcode.com/problems/course-schedule-ii/
    //     boolean[] visited = new boolean[V];
    //     boolean[] recursionCallStack = new boolean[V];
        
    //     Arrays.fill(visited,false);
    //     Arrays.fill(recursionCallStack,false);
        
    //     for(int i=0;i<V;i++)
    //     {
    //         if(!visited[i] && isCyclic(adj,visited,recursionCallStack,i))
    //         {
    //             return true;
    //         }
    //     }
    //     return false;
    // }
    
    // public static boolean isCyclic(ArrayList<ArrayList<Integer>> graph, boolean[]visited,boolean[] recursionCallStack,int vertice)
    // {
    //     visited[vertice] = true;
    //     recursionCallStack[vertice] = true;

    //     for(int adjacent_node : graph.get(vertice)){
    //         if(!visited[adjacent_node] )
    //         { 
    //             if(isCyclic(graph,visited,recursionCallStack,adjacent_node))
    //             {
    //                 return true;
    //             }
    //         }
    //         else
    //         {
    //             return recursionCallStack[adjacent_node];
    //         }
    //     }
    //     recursionCallStack[vertice] = false;
    //     return false;
    // }


    // public static List<Integer> eventualSafeNodes(int[][] graph)
    //  { //https://leetcode.com/problems/find-eventual-safe-states/
    //     int n = graph.length;
        
    //     List<Integer> arr[] = new ArrayList[n];
    //     for(int i=0; i<n; i++)
    //     { 
    //         arr[i] = new ArrayList<>();
    //     }
    //     int indegree[] = new int[n];
    //     for(int i=0; i<n; i++)
    //     {
    //         for(int j=0; j<graph[i].length; j++)
    //         {
    //             arr[graph[i][j]].add(i);
    //             indegree[i]++;
    //         }
    //     }
    //     int safe[] = new int[n];
    //     Queue<Integer> q = new LinkedList<>();
    //     for(int i=0; i<n; i++) 
    //     {
    //         if(indegree[i]==0)
    //         {
    //             q.add(i);
    //         }
    //     }
    //     while(q.size()!=0)
    //     {
    //         int a = q.remove();
    //         safe[a] = 1;
    //         for(var x : arr[a])
    //         {
    //             indegree[x]--;
    //             if(indegree[x]==0)
    //             {
    //                 q.add(x);
    //             }
    //         }
    //     }
    //     List<Integer> ans = new ArrayList<>();
    //     for(int i=0; i<n; i++)
    //     {
    //         if(safe[i]==1)
    //         {
    //             ans.add(i);
    //         }
    //     }
    //     return ans;
        
    // }


    // public static int shortestPathBinaryMatrix(int[][] grid)
    // { //https://leetcode.com/problems/shortest-path-in-binary-matrix/
    //     int n = grid.length;
    //     if(grid[0][0] == 1 || grid[n - 1][n - 1] == 1) 
    //     {
    //         return -1;
    //     }
    //     if(n == 1 && grid[0][0] == 0)
    //     {
    //         return 1;
    //     }
    //     Deque<int[]> queue = new ArrayDeque<>(); 
    //     queue.add(new int[] {0, 0, 1});
    //     while(!queue.isEmpty()) 
    //     {
    //         int[] curr = queue.pollFirst();
    //         int r = curr[0];
    //         int c = curr[1];
    //         int dist = curr[2];

    //         for(int i = r - 1; i <= r + 1; i++) 
    //         {
    //             for(int j = c - 1; j <= c + 1; j++) 
    //             {
    //                 if(i == -1 || i == n || j == -1 || j == n || grid[i][j] == 1) 
    //                 {
    //                     continue;
    //                 }
    //                 if(n - 1 == i && n - 1 == j)
    //                 { 
    //                     return dist + 1;
    //                 }
    //                 else 
    //                 {
    //                     queue.add(new int[] {i, j, dist + 1});
    //                     grid[i][j] = 1; 
    //                 }
    //             }
    //         }
    //     }
    //     return -1;
    // }

    // public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k)
    //  { //https://leetcode.com/problems/cheapest-flights-within-k-stops/
    //     List<List<int[]>> adj = new ArrayList<>();
    //     for (int i = 0; i < n; i++) 
    //     {
    //         adj.add(new ArrayList<>());
    //     }
    //     for (int[] flight : flights) 
    //     {
    //         adj.get(flight[0]).add(new int[] {flight[1], flight[2]});
    //     }
    //     Queue<int[]> q = new LinkedList<>();
    //     q.offer(new int[] {src, 0});
    //     int[] minCost = new int[n];
    //     Arrays.fill(minCost, Integer.MAX_VALUE);
    //     int stops = 0;
    //     while (!q.isEmpty() && stops <= k)
    //     {
    //         int size = q.size();
    //         while (size-- > 0)
    //         {
    //             int[] curr = q.poll();
    //             for (int[] neighbour : adj.get(curr[0])) 
    //             {
    //                 int price = neighbour[1], neighbourNode = neighbour[0];
    //                 if (price + curr[1] >= minCost[neighbourNode])
    //                 {
    //                     continue;
    //                 }
    //                 minCost[neighbourNode] = price + curr[1];
    //                 q.offer(new int[] {neighbourNode, minCost[neighbourNode]});
    //             }
    //         }
    //         stops++;
    //     }
    //     return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    // }

    // public static int minimumEffortPath(final int[][] heights) { //https://leetcode.com/problems/path-with-minimum-effort/
    //     final int[][] DIRECTIONS = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
    //     final int m = heights.length, n = heights[0].length;
    //     final int[][] h = new int[m][n];

    //     for(int i = 0; i < m; ++i)
    //         Arrays.fill(h[i], Integer.MAX_VALUE);

    //     final Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

    //     minHeap.offer(new int[] {0, 0, 0});

    //     h[0][0] = 0;

    //     while(!minHeap.isEmpty()) {
    //         final int y = minHeap.peek()[1], x = minHeap.peek()[2], currEffort = minHeap.poll()[0];

    //         if(currEffort > h[y][x])
    //             continue;

    //         if(y == m - 1 && x == n - 1)
    //             return currEffort;

    //         for(final int[] DIRECTION : DIRECTIONS) {
    //             final int ny = y + DIRECTION[0], nx = x + DIRECTION[1];

    //             if(ny >= 0 && nx >= 0 && ny < m && nx < n) {
    //                 final int newEffort = Math.max(currEffort, Math.abs(heights[y][x] - heights[ny][nx]));

    //                 if(newEffort < h[ny][nx]) {
    //                     h[ny][nx] = newEffort;
    //                     minHeap.offer(new int[] { newEffort, ny, nx });
    //                 }
    //             }
    //         }
    //     }

    //     return h[m - 1][n - 1];
    // }
    

    // public static int networkDelayTime(int[][] times, int n, int k) { //https://leetcode.com/problems/network-delay-time/
    //     // Create adjacency list
    //     Map<Integer, List<int[]>> adjacency = new HashMap<>();
    //     for (int[] time : times) {
    //         int src = time[0];
    //         int dst = time[1];
    //         int t = time[2];
    //         adjacency.computeIfAbsent(src, key -> new ArrayList<>()).add(new int[] { dst, t });
    //     }

    //     // Priority queue for Dijkstra's algorithm (min-heap based on time)
    //     PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
    //     pq.add(new int[] { k, 0 });
    //     Set<Integer> visited = new HashSet<>();
    //     int delays = 0;

    //     while (!pq.isEmpty()) {
    //         int[] current = pq.poll();
    //         int time = current[1];
    //         int node = current[0];

    //         // Skip if the node has been visited
    //         if (!visited.add(node)) {
    //             continue;
    //         }

    //         delays = Math.max(delays, time);
    //         List<int[]> neighbors = adjacency.getOrDefault(node, new ArrayList<>());

    //         for (int[] neighbor : neighbors) {
    //             int neighborNode = neighbor[0];
    //             int neighborTime = neighbor[1];
    //             if (!visited.contains(neighborNode)) {
    //                 pq.add(new int[] { neighborNode, time + neighborTime });
    //             }
    //         }
    //     }

    //     // Check if all nodes have been visited
    //     return visited.size() == n ? delays : -1;
    // }


    

    // public static int countPaths(int n, int[][] roads) {//https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/
    //     int mod = (int) (1e9 + 7);
    //     // build the ajacency list, int[] {cityNumber, time needed}
    //     List<List<int[]>> adj = new ArrayList<>();
    //     for (int i = 0; i < n; i++) {
    //         adj.add(new ArrayList<>());
    //     }
    //     for (int[] road : roads) { // bi-directional
    //         adj.get(road[0]).add(new int[] {road[1], road[2]});
    //         adj.get(road[1]).add(new int[] {road[0], road[2]});
    //     }

    //     // track the paths
    //     long[] numOfPaths = new long[n];
    //     long[] shortestTimes = new long[n];
    //     numOfPaths[0] = 1;
    //     shortestTimes[0] = 0;
    //     Arrays.fill(shortestTimes, Long.MAX_VALUE);


    //     // performing a bfs with priorityQueue to find the shortest amount of time
    //     PriorityQueue<long[]> heap = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1])); // minHeap
    //     heap.add(new long[]{0, 0});
    //     while (!heap.isEmpty()) {
    //         long[] curr = heap.poll(); 
    //         int city = (int) curr[0];
    //         long time = curr[1];

    //         for (int[] neighbor : adj.get(city)) {
    //             int neighborCity = neighbor[0];
    //             long neighborTime = neighbor[1];
    //             if (time + neighborTime > shortestTimes[neighborCity] || time + neighborTime > shortestTimes[n - 1]) {
    //                 continue;
    //             }

    //             if (time + neighborTime == shortestTimes[neighborCity]) {
    //                 numOfPaths[neighborCity] = (numOfPaths[neighborCity] + numOfPaths[city]) % mod;
    //             } else {
    //                 shortestTimes[neighborCity] = time + neighborTime;
    //                 numOfPaths[neighborCity] = numOfPaths[city];
    //                 heap.offer(new long[] {neighborCity, neighborTime + time});
    //             }
                
    //         }
    //     }
    //     return (int) (numOfPaths[n - 1] % mod);
    // }

    // public static int findTheCity(int n, int[][] edges, int distanceThreshold) { //https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
    //     int[][] dis = new int[n][n];
    //     for (int[] row : dis) {
    //         Arrays.fill(row, 10001);
    //     }
    //     for (int[] edge : edges) {
    //         dis[edge[0]][edge[1]] = dis[edge[1]][edge[0]] = edge[2];
    //     }

    //     // diagonal as zero
    //     for (int i = 0; i < n; i++) {
    //         dis[i][i] = 0;
    //     }

    //     // FLOYYD ALGO
    //     for (int k = 0; k < n; k++) {
    //         for (int i = 0; i < n; i++) {
    //             for (int j = 0; j < n; j++) {
    //                 dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
    //             }
    //         }
    //     }

    //     int res = 0, smallest = n;
    //     for (int i = 0; i < n; i++) {
    //         int cnt = 0;
    //         for (int j = 0; j < n; j++) {
    //             if (dis[i][j] <= distanceThreshold) {
    //                 cnt++;
    //             }
    //         }

    //         if (cnt <= smallest) {
    //             res = i;
    //             smallest = cnt;
    //         }
    //     }
    //     return res;
    // }

    // public static int dfs(int u, List<Integer>[] graph, boolean[] visited) { //https://leetcode.com/problems/number-of-provinces/
    //     if (visited[u]) return 0;
    //     visited[u] = true;
    //     for (int v : graph[u]) dfs(v, graph, visited);
    //     return 1;
    // }

    // public static int makeConnected(int n, int[][] connections) {
    //     if (connections.length < n - 1) return -1;
    //     List<Integer>[] graph = new List[n];
    //     for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
    //     for (int[] c : connections) {
    //         graph[c[0]].add(c[1]);
    //         graph[c[1]].add(c[0]);
    //     }
        
    //     int components = 0;
    //     boolean[] visited = new boolean[n];
    //     for (int v = 0; v < n; v++) components += dfs(v, graph, visited);
    //     return components - 1;
    // }
    

    // public static List<List<String>> accountsMerge(List<List<String>> accounts) { //https://leetcode.com/problems/accounts-merge/
    //     Map<String, Set<String>> adj = new HashMap<>();

    //     for(List<String> account : accounts) {
    //         String email1 = account.get(1);
    //         for(int i = 2; i < account.size(); i++) {
    //             String curEmail = account.get(i);
    //             adj.computeIfAbsent(email1, k->new HashSet<>()).add(curEmail);
    //             adj.computeIfAbsent(curEmail, k->new HashSet<>()).add(email1);
    //         }
    //     }
    //     Set<String> visited = new HashSet<>();
    //     List<List<String>> result = new ArrayList<>();

    //     for(List<String> account : accounts) {
    //         String email1 = account.get(1);
    //         if(visited.contains(email1))
    //             continue;
    //         ArrayList<String> mergedEmails = new ArrayList<>();
    //         dfs(email1, adj, mergedEmails, visited);
    //         if(mergedEmails.size() > 1)
    //             Collections.sort(mergedEmails);
    //         mergedEmails.add(0, account.get(0));//add name
    //         result.add(mergedEmails);
    //     }
    //     return result;
    // }

    // public static void dfs(String email, Map<String, Set<String>> adj, List<String> mergedEmails, Set<String> visited) {
    //     if(visited.contains(email))
    //         return;
    //     mergedEmails.add(email);
    //     visited.add(email);
    //     for(String nextEmail : adj.getOrDefault(email, Collections.emptySet())) {
    //         dfs(nextEmail, adj, mergedEmails, visited);
    //     }
    // }



    
}