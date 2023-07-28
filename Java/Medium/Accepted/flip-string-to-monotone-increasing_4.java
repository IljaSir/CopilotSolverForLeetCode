class Solution {
    public int minFlipsMonoIncr(String s) {
        
        int n = s.length();
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            sum[i + 1] = sum[i] + (s.charAt(i) == '1' ? 1 : 0);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= n; ++i) {
            ans = Math.min(ans, sum[i] + n - i - (sum[n] - sum[i]));
        }
        return ans;
    }
}