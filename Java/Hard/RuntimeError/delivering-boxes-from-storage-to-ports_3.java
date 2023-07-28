class Solution {
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        
        int n = boxes.length;
        int[] dp = new int[n + 1];
        int[] next = new int[n];
        int[] last = new int[portsCount + 1];
        Arrays.fill(last, -1);
        int i = 0;
        for (int j = 0; j < n; ++j) {
            next[i] = j + 1;
            while (i < n && next[i] - i <= maxBoxes && boxes[i][1] + boxes[next[i]][1] <= maxWeight) {
                next[i] += 1;
            }
            last[boxes[j][0]] = j;
            dp[j + 1] = dp[i] + 2;
            if (i > 0) {
                dp[j + 1] = Math.min(dp[j + 1], dp[i - 1] + 1);
            }
            i = next[i] - 1;
        }
        return dp[n];
    }
}