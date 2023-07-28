class Solution {
    public int catMouseGame(int[][] graph) {
        
        int n = graph.length;
        int[][][] color = new int[n][n][2];
        int[][][] degree = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                degree[i][j][0] = graph[i].length;
                degree[i][j][1] = graph[j].length;
                for (int k : graph[j]) {
                    if (k == 0) {
                        degree[i][j][1]--;
                    }
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                for (int k = 0; k < 2; k++) {
                    if (i == 0 && k == 1) {
                        continue;
                    }
                    if (i == j && k == 0) {
                        continue;
                    }
                    color[i][j][k] = k + 1;
                    queue.offer(new int[]{i, j, k});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int i = cur[0], j = cur[1], k = cur[2];
            int next = k ^ 1;
            for (int node : graph[k == 0 ? i : j]) {
                if (node == 0 && k == 1) {
                    continue;
                }
                if (color[node][j][next] == 0) {
                    if (next == color[i][j][k] - 1) {
                        color[node][j][next] = next + 1;
                        queue.offer(new int[]{node, j, next});
                    } else if (--degree[node][j][next] == 0) {
                        color[node][j][next] = color[i][j][k];
                        queue.offer(new int[]{node, j, next});
                    }
                }
            }
        }
        return color[1][2][0] - 1;
    }
}