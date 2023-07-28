class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        
        int[] inDegree = new int[n];
        for (int[] r : relations) {
            inDegree[r[1] - 1]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }
        int[] dp = new int[n];
        while (!q.isEmpty()) {
            int cur = q.poll();
            dp[cur] += time[cur];
            for (int[] r : relations) {
                if (r[0] - 1 == cur) {
                    dp[r[1] - 1] = Math.max(dp[r[1] - 1], dp[cur]);
                    if (--inDegree[r[1] - 1] == 0) {
                        q.offer(r[1] - 1);
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}