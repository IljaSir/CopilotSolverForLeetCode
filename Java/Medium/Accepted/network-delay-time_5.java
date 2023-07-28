class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k-1] = 0;
        for (int i = 0; i < n; i++) {
            for (int[] time : times) {
                int u = time[0] - 1, v = time[1] - 1, w = time[2];
                if (dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                }
            }
        }
        int ans = 0;
        for (int time : dist) {
            if (time == Integer.MAX_VALUE) {
                return -1;
            }
            ans = Math.max(ans, time);
        }
        return ans;
    }
}