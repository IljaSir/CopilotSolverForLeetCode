class Solution {
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        
        int n = floor.length();
        int[] dp = new int[n];
        int[] sum = new int[n];
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            if (i >= carpetLen) {
                dp[i] = dp[i - carpetLen];
                sum[i] = sum[i - carpetLen];
                count[i] = count[i - carpetLen];
            }
            if (floor.charAt(i) == '1') {
                dp[i] += 1;
                sum[i] += i;
                count[i] += 1;
            }
            if (i >= carpetLen) {
                int j = i - carpetLen;
                if (dp[j] > dp[i]) {
                    dp[i] = dp[j];
                    sum[i] = sum[j];
                    count[i] = count[j];
                } else if (dp[j] == dp[i]) {
                    int sum1 = sum[j] + j * count[j];
                    int sum2 = sum[i] + i * count[i];
                    if (sum1 < sum2) {
                        sum[i] = sum[j];
                        count[i] = count[j];
                    }
                }
            }
        }
        return n - dp[n - 1];
    }
}