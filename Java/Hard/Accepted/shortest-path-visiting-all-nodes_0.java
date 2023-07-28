class Solution {
    public int shortestPathLength(int[][] graph) {
        
        int N = graph.length;
        Queue<int[]> queue = new LinkedList();
        Set<String> seen = new HashSet();
        for (int x = 0; x < N; ++x) {
            queue.offer(new int[]{x, 1 << x, 0});
            seen.add(x + " " + (1 << x));
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int u = node[0], mask = node[1], dist = node[2];
            if (mask == (1 << N) - 1) {
                ans = dist;
                break;
            }

            // Visiting nei in graph[u]
            for (int nei: graph[u]) {
                // Mask & (1 << nei) > 0: has visited node nei
                // mask | (1 << nei): add node nei to visited set
                String key = nei + " " + (mask | (1 << nei));
                if (!seen.contains(key)) {
                    queue.offer(new int[]{nei, mask | (1 << nei), dist + 1});
                    seen.add(key);
                }
            }
        }

        return ans;
    }
}