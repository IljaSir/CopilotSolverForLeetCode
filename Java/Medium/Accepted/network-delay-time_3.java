class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        for (int i = 1; i < n; i++) {
            for (int[] time : times) {
                if (dist[time[0]] != Integer.MAX_VALUE) {
                    dist[time[1]] = Math.min(dist[time[1]], dist[time[0]] + time[2]);
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dist[i]);
        }
        return max == Integer.MAX_VALUE ? -1 : max;
    }
}