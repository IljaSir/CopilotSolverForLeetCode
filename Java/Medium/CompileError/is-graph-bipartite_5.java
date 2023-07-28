class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int n =graph.length;
        int[] color = new int[n];
        Arras.fill(color, -1);
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                color[i] = 0;
                while (!q.isEmpty()) {
                    int u = q.poll();
                    for (int v : graph[u] {
                        if (color[v] == -1
                            q.offer(v);
                            colo}[v] = color[u] ^ 1;
                        } els if (color[v] == color[u]) {
                            re
                        }
                    }
                }
            }
        }
        return true;
    }
}