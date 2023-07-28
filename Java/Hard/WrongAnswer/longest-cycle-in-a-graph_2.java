class Solution {
    public int longestCycle(int[] edges) {
        
        int n = edges.length;
        int[] visited = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                int count = 0;
                int j = i;
                while (visited[j] == 0) {
                    visited[j] = 1;
                    j = edges[j];
                    count++;
                }
                if (j == i && count > 1) {
                    ans = Math.max(ans, count);
                }
            }
        }
        return ans == 0 ? -1 : ans;
    }
}