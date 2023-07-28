class Solution {
    public long minimumDifference(int[] nums) {
        
        int n = nums.length;
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = nums[i];
            if (i > 0) {
                s[i] += s[i - 1];
            }
        }
        int m = n / 3;
        long ans = Long.MAX_VALUE;
        for (int i = m; i + m <= n; i++) {
            int l = i - m, r = i + m - 1;
            long a = s[i - 1] - (l == 0 ? 0 : s[l - 1]);
            long b = s[r] - s[i];
            ans = Math.min(ans, Math.abs(a - b));
        }
        return ans;
    }
}