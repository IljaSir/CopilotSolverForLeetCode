class Solution {
    public int maximumInvitations(int[] favorite) {
        
        int n = favorite.length;
        int[] next = new int[n];
        for (int i = 0; i < n; i++) {
            next[i] = favorite[i];
        }
        int[] vis = new int[n];
        int[] pre = new int[n];
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i] != 0) {
                continue;
            }
            int cnt = 0;
            int j = i;
            while (vis[j] == 0) {
                vis[j] = 1;
                j = next[j];
                cnt++;
            }
            int s = 0;
            j = i;
            while (vis[j] == 1) {
                vis[j] = 2;
                pre[j] = s;
                s += cnt;
                j = next[j];
                cnt--;
            }
            j = i;
            while (vis[j] == 2) {
                vis[j] = 3;
                dp[j] = s;
                s -= pre[j];
                j = next[j];
            }
        }
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}