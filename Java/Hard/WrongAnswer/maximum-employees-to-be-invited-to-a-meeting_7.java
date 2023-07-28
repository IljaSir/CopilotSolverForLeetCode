class Solution {
    public int maximumInvitations(int[] favorite) {
        
        int n = favorite.length;
        int[] next = new int[n];
        int[] dp = new int[n];
        Arrays.fill(next, -1);
        for (int i = 0; i < n; i++) {
            int j = i;
            boolean[] visited = new boolean[n];
            while (next[j] == -1 && !visited[j]) {
                visited[j] = true;
                j = favorite[j];
            }
            if (next[j] == -1) {
                next[j] = i;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (next[i] != -1) {
                int j = i;
                int cnt = 0;
                while (next[j] != -1) {
                    cnt++;
                    j = next[j];
                }
                ans += cnt;
                dp[i] = cnt;
            }
        }
        for (int i = 0; i < n; i++) {
            if (next[i] == -1) {
                ans += dp[favorite[i]];
            }
        }
        return ans;
    }
}