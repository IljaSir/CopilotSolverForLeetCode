class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        
        int n = costs.length;
        long[][] dp = new long[k + 1][n + 1];
        for (int i = 1; i <= k; i++) {
            PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            for (int j = 0; j < candidates; j++) {
                pq.add(new int[]{costs[j], j});
            }
            for (int j = 0; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + pq.peek()[0];
                if (j + candidates < n) {
                    pq.add(new int[]{costs[j + candidates], j + candidates});
                }
                while (pq.peek()[1] <= j) {
                    pq.poll();]));
        }
        return ans;
    }
}
    }
}