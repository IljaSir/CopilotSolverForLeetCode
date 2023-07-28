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
            // Visiting children.
            for (int v: graph[u]) {
                // Visiting v from u.
                int maskV = mask | (1 << v);
                if (!seen.contains(v + " " + maskV)) {
                    queue.offer(new int[]{v, maskV, dist + 1});
                    seen.add(v + " " + maskV);
                }
            }
        }
        return ans;
    }
}