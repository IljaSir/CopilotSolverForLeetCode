class Solution {
    public int waysToSplitArray(int[] nums) {
        
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for(int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        int ans = 0;
        final int mod = 1_000_000_007;
        for(int i = 0; i < n - 2; i++) {
            int l = i + 1;
            int r = n - 1;
            int s = sum[i];
            while(l < r) {
                int m = (l + r) / 2;
                int left = sum[m] - s;
                int right = sum[n - 1] - sum[m];
                if(left < right) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            int left = sum[r - 1] - s;
            int right = sum[n - 1] - sum[r - 1];
            if(left > right) {
                continue;
            }
            int ll = r;
            int rr = n - 1;
            while(ll < rr) {
                int m = (ll + rr + 1) / 2;
                left = sum[m] - s;
                right = sum[n - 1] - sum[m];
                if(left <= right) {
                    ll = m;
                } else {
                    rr = m - 1;
                }
            }
            ans += ll - r + 1;
            ans %= mod;
        }
        return ans;
    }
}