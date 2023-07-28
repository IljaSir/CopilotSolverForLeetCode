class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        
        int[] sum = new int[n + 1];
        for (int i = 0; i < banned.length; i++) {
            sum[banned[i]] = -1;
        }
        sum[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (sum[i] == -1) {
                continue;
            }
            sum[i] = sum[i - 1];
            if (i - 1 - maxSum >= 0 && sum[i - 1 - maxSum] > 0) {
                sum[i] -= sum[i - 1 - maxSum];
            }
            if (i - maxSum >= 0 && sum[i - maxSum] > 0) {
                sum[i] += sum[i - maxSum];
            }
        }
        return sum[n];
    }
}