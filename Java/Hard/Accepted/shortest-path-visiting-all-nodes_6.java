class Solution {
    public int shortestPathLength(int[][] graph) {
        
        int n = graph.length;
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            queue.offer(new int[]{i, 1 << i});
            visited.add(i + "," + (1 << i));
        }
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int node = cur[0], mask = cur[1];
                if (mask == (1 << n) - 1) {
                    return step;
                }
                for (int next : graph[node]) {
                    int nextMask = mask | (1 << next);
                    if (!visited.contains(next + "," + nextMask)) {
                        queue.offer(new int[]{next, nextMask});
                        visited.add(next + "," + nextMask);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}