class Solution {
    public int maximumTastiness(int[] price, int k) {
        
        Arrays.sort(price);
        int n = price.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + price[i - 1];
        }
        int res = 0;
        for (int i = 0; i < n - k + 1; i++) {
            res = Math.max(res, sum[i + k] - sum[i]);
        }
        return res;
    }
}