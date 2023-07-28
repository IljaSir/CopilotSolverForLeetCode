class Solution {
    public int maximumTastiness(int[] price, int k) {
        
        int n = price.length;
        Arrays.sort(price);
        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans += price[n - i - 1];
        }
        int min = ans;
        for (int i = 0; i < k; i++) {
            min -= price[n - i - 1];
            min += price[i];
            ans = Math.max(ans, min);
        }
        return ans;
    }
}