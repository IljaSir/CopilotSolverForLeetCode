class Solution {
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        
        int n = boxes.length;
        int[] next = new int[n];
        int right = 0, weight = 0;
        for (int i = 0; i < n; ++i) {
            while (right < n && (right == i || boxes[right][0] == boxes[right - 1][0])) {
                weight += boxes[right][1];
                ++right;
            }
            next[i] = right;
        }
        int[] dp = new int[n + 1];
        int inf = 1000000000;
        Arrays.fill(dp, inf);
        dp[0] = 0;
        for (int i = 0, rightSum = 0, rightWeight = 0; i < n; i = next[i]) {
            rightSum = dp[i];
            rightWeight = 0;
            for (int j = i; j < next[i]; ++j) {
                rightWeight += boxes[j][1];
                rightSum += 1;
                if (j + 1 < next[i] && boxes[j][0] != boxes[j + 1][0]) {
                    dp[next[i]] = Math.min(dp[next[i]], rightSum);
                }
            }
            if (i + maxBoxes <= n) {
                dp[i + maxBoxes] = Math.min(dp[i + maxBoxes], rightSum + 1);
            }
            if (i + 1 < n && boxes[i][0] != boxes[i + 1][0]) {
                dp[i + 1] = Math.min(dp[i + 1], rightSum + 1);
            }
        }
        return dp[n];
    }
}