class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        
        int[][] graph = new int[n][n];
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }
        int minCycle = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[i] = 0;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int j = 0; j < n; j++) {
                    if (graph[cur][j] == 1) {
                        if (dist[j] == Integer.MAX_VALUE) {
                            queue.offer(j);
                            dist[j] = dist[cur] + 1;
                        } else if (dist[j] >= dist[cur]) {
                            minCycle = Math.min(minCycle, dist[j] + dist[cur] + 1);
                        }
                    }
                }
            }
        }
        return minCycle == Integer.MAX_VALUE ? -1 : minCycle;
    }
}