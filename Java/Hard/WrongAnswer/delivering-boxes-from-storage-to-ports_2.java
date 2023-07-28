class Solution {
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        
        int n = boxes.length;
        int[] next = new int[n];
        int j = n;
        long weight = 0;
        for (int i = n - 1; i >= 0; i--) {
            weight += boxes[i][1];
            while (j > i && (j == n || boxes[j][0] != boxes[i][0])) {
                j--;
                weight -= boxes[j][1];
            }
            next[i] = j;
        }
        int[] dp = new int[n + 1];
        int[] best = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = dp[next[i]] + 2;
            best[i] = Math.min(n, next[i] + maxBoxes);
            if (i + 1 < n && boxes[i][0] == boxes[i + 1][0]) {
                dp[i] = Math.min(dp[i], dp[i + 1] + 1);
                best[i] = Math.min(best[i], best[i + 1] + 1);
            }
            int lo = i + 1, hi = best[i];
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (next[i] < mid) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            if (lo < best[i]) {
                int mid = (lo + hi) / 2;
                long w = 0;
                for (int k = i; k < mid; k++) {
                    w += boxes[k][1];
                }
                if (w <= maxWeight) {
                    dp[i] = Math.min(dp[i], dp[lo] + 1);
                }
            }
        }
        return dp[0];
    }
}