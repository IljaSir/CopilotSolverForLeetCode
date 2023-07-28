class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int[] dist = new int[n];
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        int minCycle = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (parent[i] == -1) {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                parent[i] = i;
                dist[i] = 0;
                while (!queue.isEmpty()) {
                    int curr = queue.poll();
                    for (int next : graph[curr]) {
                        if (parent[next] == -1) {
                            parent[next] = curr;
                            dist[next] = dist[curr] + 1;
                            queue.offer(next);
                        } else if (parent[curr] != next) {
                            minCycle = Math.min(minCycle, dist[curr] + dist[next] + 1);
                        }
                    }
                }
            }
        }
        return minCycle == Integer.MAX_VALUE ? -1 : minCycle;
    }
}