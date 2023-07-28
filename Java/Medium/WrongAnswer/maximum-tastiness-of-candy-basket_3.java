class Solution {
    public int maximumTastiness(int[] price, int k) {
        
        int n = price.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + price[i - 1];
        }
        int max = 0;
        for (int i = 0; i + k <= n; i++) {
            max = Math.max(max, sum[i + k] - sum[i]);
        }
        return max;
    }
}