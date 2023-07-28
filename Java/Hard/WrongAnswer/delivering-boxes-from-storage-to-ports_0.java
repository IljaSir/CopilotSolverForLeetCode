class Solution {
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        
        int n = boxes.length;
        int[] ports = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            ports[i] = boxes[i][0];
            weights[i] = boxes[i][1];
        }

        int[] next = new int[n];
        int right = n;
        int rightWeight = 0;
        for (int i = n - 1; i >= 0; i--) {
            rightWeight += weights[i];
            while (right > i && (right - i > maxBoxes || rightWeight > maxWeight)) {
                rightWeight -= weights[--right];
            }
            next[i] = right;
        }

        int[] dp = new int[n + 1];
        int[] minDp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE / 2;
            minDp[i] = Integer.MAX_VALUE / 2;
            dp[i] = Math.min(dp[i], dp[next[i]] + 1);
            minDp[i] = Math.min(minDp[i], dp[i]);
            if (i + 1 < n && ports[i] != ports[i + 1]) {
                dp[i] = Math.min(dp[i], minDp[next[i]] + 2);
            }
            minDp[i] = Math.min(minDp[i], dp[i]);
        }

        return dp[0];
    }
}