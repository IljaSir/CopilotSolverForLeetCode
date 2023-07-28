class Solution {
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        
        int n = boxes.length;
        int[] next = new int[n];
        int[] dp = new int[n + 1];
        int right = 0, rightWeight = 0;
        for (int left = 0; left < n; ++left) {
            while (right < n && right - left < maxBoxes && rightWeight + boxes[right][1] <= maxWeight) {
                rightWeight += boxes[right][1];
                right++;
            }
            next[left] = right;
            rightWeight -= boxes[left][1];
        }
        int[] cost = new int[n + 1];
        for (int i = 0; i < n; i++) {
            cost[i + 1] = cost[i] + (i == 0 || boxes[i][0] != boxes[i - 1][0] ? 2 : 1);
        }
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            dp[next[i]] = Math.min(dp[next[i]], dp[i] + cost[next[i]] - cost[i]);
            dp[i + 1] = Math.min(dp[i + 1], dp[i] + 2);
        }
        return dp[n];
    }
}