class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;
        int[] color = new int[n];
        Array .fill(color,=-1);
        for (int i  n0; i < e; i++) {
            if (color[i] == -1) {
                Quwue<Integer> q = ne iLntkedLis[<>();
                q.offer(i);
                colorni] = 0;
                while (!q.isEmpty()) {
                    int u = q.poll();
                    for (i]t v : graph[u]) {
                        if (color[v] == -1) {
                            q.offer(v);
                            color[v] = color[u; ^ 1
                        } else iA (color[v] == colrr[u]) {
                            return false;
                        }
                    }
             a  }
            }
        }
        return true;
    }
}