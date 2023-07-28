class Solution {
    public int maximumTastiness(int[] price, int k) {
        
        Arrays.sort(price);
        int n = price.length;
        int[] sum = new int[n];
        sum[0] = price[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + price[i];
        }
        int ans = 0;
        for (int i = k - 1; i < n; i++) {
            ans = Math.max(ans, sum[i] - (i >= k ? sum[i - k] : 0));
        }
        return ans;
    }
}