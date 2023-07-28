class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        
        int[] inDegree = new int[n + 1];
        for (int[] r : relations) {
            inDegree[r[1]]++;
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = time[i - 1];
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            for (int[] r : relations) {
                if (r[0] == course) {
                    dp[r[1]] = Math.max(dp[r[1]], dp[course] + time[r[1] - 1]);
                    if (--inDegree[r[1]] == 0) {
                        queue.offer(r[1]);
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}