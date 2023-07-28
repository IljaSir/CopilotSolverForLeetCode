class Solution {
    public int maximumTastiness(int[] price, int k) {
        
        Arrays.sort(price);
        int n = price.length;
        int[] preSum = new int[n];
        preSum[0] = price[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + price[i];
        }
        int ans = 0;
        for (int i = k - 1; i < n; i++) {
            int sum = preSum[i];
            if (i - k >= 0) {
                sum -= preSum[i - k];
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}