class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        
        int n = 6000;
        boolean[] f = new boolean[n];
        for (int i = 0; i < forbidden.length; i++) {
            f[forbidden[i]] = true;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while (!q.isEmpty()) {
            int u = q.poll();
            if (u == x) {
                return dp[u];
            }
            int v = u + a;
            if (v < n && !f[v] && dp[v] > dp[u] + 1) {
                dp[v] = dp[u] + 1;
                q.offer(v);
            }
            v = u - b;
            if (u - b >= 0 && !f[v] && u - b != u + a && dp[v] > dp[u] + 1) {
                dp[v] = dp[u] + 1;
                q.offer(v);
            }
        }
        return -1;
    }
}