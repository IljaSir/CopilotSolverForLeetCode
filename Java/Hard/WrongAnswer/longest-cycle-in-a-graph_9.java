class Solution {
    public int longestCycle(int[] edges) {
        
        int n = edges.length;
        int[] visited = new int[n];
        int[] path = new int[n];
        int[] cycle = new int[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] != 0) continue;
            int cur = i;
            int count = 0;
            while (visited[cur] == 0) {
                visited[cur] = 1;
                path[count++] = cur;
                cur = edges[cur];
            }
            if (visited[cur] == 1) {
                for (int j = 0; j < count; j++) {
                    visited[path[j]] = 2;
                    if (path[j] == cur) break;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 2) {
                int cur = i;
                int count = 0;
                while (cycle[cur] == 0) {
                    cycle[cur] = 1;
                    count++;
                    cur = edges[cur];
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}