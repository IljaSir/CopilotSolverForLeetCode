class Solution {
    public int maximumTastiness(int[] price, int k) {
        
        int n = price.length;
        Arrays.sort(price);
        int ans = 0;
        for (int i = 0; i < k; ++i) {
            ans += price[n - 1 - i];
        }
        int sum = ans;
        for (int i = k; i < n; ++i) {
            sum += price[n - 1 - i] - price[i - k];
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}