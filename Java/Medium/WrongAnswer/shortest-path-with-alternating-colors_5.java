class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = -1;
        }
        result[0] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        queue.add(new int[]{0, 1});
        boolean[][] visited = new boolean[n][2];
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int color = current[1];
            int nextColor = color == 0 ? 1 : 0;
            for (int[] edge : nextColor == 0 ? redEdges : blueEdges) {
                if (edge[0] == node) {
                    if (visited[edge[1]][nextColor]) {
                        continue;
                    }
                    result[edge[1]] = result[edge[1]] == -1 ? result[node] + 1 : Math.min(result[edge[1]], result[node] + 1);
                    visited[edge[1]][nextColor] = true;
                    queue.add(new int[]{edge[1], nextColor});
                }
            }
        }
        return result;
    }
}