class Solution {
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        
        int n = boxes.length;
        int[] dp = new int[n + 1];
        int[] next = new int[n + 1];
        int j = 0;
        int sumw = 0;
        int sumb = 0;
        for (int i = 0; i < n; i++) {
            sumw += boxes[i][1];
            sumb++;
            while (j < n && (sumw > maxWeight || sumb > maxBoxes || (i < n - 1 && boxes[i][0] != boxes[i + 1][0]))) {
                sumw -= boxes[j][1];
                sumb--;
                j++;
            }
            if (i > 0 && boxes[i][0] != boxes[i - 1][0]) {
                dp[i + 1] = dp[j] + 2;
            } else {
                dp[i + 1] = dp[j] + 1;
            }
            next[i + 1] = j;
        }
        return dp[n];
    }
}