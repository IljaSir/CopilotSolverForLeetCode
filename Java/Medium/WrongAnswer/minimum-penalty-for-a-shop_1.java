class Solution {
    public int bestClosingTime(String customers) {
        
        int n = customers.length();
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + (customers.charAt(i) == 'Y' ? 1 : 0);
        }
        int ans = n;
        int min = 0;
        for (int i = 0; i < n; i++) {
            int cur = sum[i] + (n - i - (sum[n] - sum[i]));
            if (cur < min) {
                min = cur;
                ans = i;
            }
        }
        return ans;
    }
}