class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        
        int[][] adj = new int[n][n];
        for (int[] edge : edges) {
            adj[edge[0]][edge[1]] = 1;
            adj[edge[1]][edge[0]] = 1;
        }
        int minCycle = Integer.MAX_VALUE;
        for (int[] edge : edges) {
            int[] visited = new int[n];
            int start = edge[0];
            int end = edge[1];
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{start, 0});
            while (!queue.isEmpty()) {
                int[] node = queue.poll();
                if (node[0] == end) {
                    minCycle = Math.min(minCycle, node[1]);
                    break;
                }
                visited[node[0]] = 1;
                for (int i = 0; i < n; i++) {
                    if (adj[node[0]][i] == 1 && visited[i] == 0) {
                        queue.add(new int[]{i, node[1] + 1});
                    }
                }
            }
        }
        return minCycle == Integer.MAX_VALUE ? -1 : minCycle;
    }
}