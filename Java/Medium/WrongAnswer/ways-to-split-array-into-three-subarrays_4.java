class Solution {
    public int waysToSplit(int[] nums) {
        
        int mod = 1000000007;
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        int ans = 0;
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1, r = n - 1;
            int s1 = sum[i];
            while (l < r) {
                int m = (l + r + 1) / 2;
                int s2 = sum[m] - sum[i];
                int s3 = sum[n - 1] - sum[m];
                if (s2 < s1) {
                    l = m;
                } else {
                    r = m - 1;
                }
            }
            int left = l;
            l = i + 1;
            r = n - 1;
            while (l < r) {
                int m = (l + r) / 2;
                int s2 = sum[m] - sum[i];
                int s3 = sum[n - 1] - sum[m];
                if (s3 < s2) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            int right = r;
            if (left < right) {
                ans = (ans + right - left) % mod;
            }
        }
        return ans;
    }
}