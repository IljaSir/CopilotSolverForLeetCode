class Solution {
    public int longestCycle(int[] edges) {
        
        int n = edges.length;
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (dist[i] != -1) continue;
            int p = i;
            while (dist[p] == -1) {
                dist[p] = i;
                p = edges[p];
            }
            if (dist[p] == i) {
                int len = 1;
                for (int q = edges[p]; q != p; q = edges[q]) {
                    len++;
                }
                ans = Math.max(ans, len);
            }
        }
        return ans == 1 ? -1 : ans;
    }
}