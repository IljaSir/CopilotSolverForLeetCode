class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        
        int[] result = new int[n];
        Arrays.fill(result, -1);
        result[0] = 0;
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<int[]>());
        }
        for (int[] edge : redEdges) {
            graph.get(edge[0]).add(new int[] {edge[1], 0});
        }
        for (int[] edge : blueEdges) {
            graph.get(edge[0]).add(new int[] {edge[1], 1});
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        queue.add(new int[] {0, 1});
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] next : graph.get(cur[0])) {
                    if (next[1] == cur[1]) {
                        continue;
                    }
                    if (result[next[0]] == -1) {
                        result[next[0]] = step;
                        queue.add(next);
                    }
                }
            }
        }
        return result;
    }
}