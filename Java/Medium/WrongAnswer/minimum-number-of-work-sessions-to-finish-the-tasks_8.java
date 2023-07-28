class Solution {
    public int minSessions(int[] tasks, int sessionTime) {
        
        int n = tasks.length;
        int[] dp = new int[1 << n];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for(int state = 0; state < (1 << n); state++) {
            int time = 0;
            for(int i = 0; i < n; i++) {
                if(((state >> i) & 1) == 0) {
                    time += tasks[i];
                }
            }
            int remain = sessionTime - time % sessionTime;
            for(int i = 0; i < n; i++) {
                if(((state >> i) & 1) == 0) {
                    int next = state | (1 << i);
                    if(tasks[i] <= remain) {
                        dp[next] = Math.min(dp[next], dp[state]);
                    } else {
                        dp[next] = Math.min(dp[next], dp[state] + 1);
                    }
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}