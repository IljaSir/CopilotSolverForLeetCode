class Solution {
    public int waysToSplit(int[] nums) {
        
        int mod = 1000000007;
        int len = nums.length;
        int[] sum = new int[len];
        sum[0] = nums[0];
        for (int i = 1; i < len; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        int ans = 0;
        for (int i = 0; i < len - 2; i++) {
            int left = sum[i];
            int mid = left;
            int right = sum[len - 1] - left;
            int l = i + 1;
            int r = len - 2;
            while (l <= r) {
                int m = l + (r - l) / 2;
                int m1 = sum[m] - left;
                int m2 = right - m1;
                if (m1 <= m2) {
                    l = m + 1;
                    mid = Math.max(mid, m1);
                } else {
                    r = m - 1;
                }
            }
            if (mid >= left) {
                ans = (ans + l - i - 1) % mod;
            }
        }
        return ans;
    }
}