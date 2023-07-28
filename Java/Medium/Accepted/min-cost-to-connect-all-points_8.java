class Solution {
    public int minCostConnectPoints(int[][] points) {
        
        int N = points.length;
        int[] dist = new int[N];
        boolean[] used = new boolean[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        int ans = 0;
        for (int i = 0; i < N; ++i) {
            int x = -1;
            for (int y = 0; y < N; ++y)
                if (!used[y] && (x == -1 || dist[y] < dist[x]))
                    x = y;
            used[x] = true;
            ans += dist[x];
            for (int y = 0; y < N; ++y)
                dist[y] = Math.min(dist[y], Math.abs(points[x][0] - points[y][0]) + Math.abs(points[x][1] - points[y][1]));
        }
        return ans;
    }
}