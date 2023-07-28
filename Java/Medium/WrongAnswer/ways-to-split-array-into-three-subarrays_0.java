class Solution {
    public int waysToSplit(int[] nums) {
        
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        int ans = 0;
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1, r = n - 1;
            while (l < r) {
                int m = (l + r) / 2;
                if (sum[m] - sum[i] >= sum[i]) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            if (sum[l] - sum[i] < sum[i]) {
                continue;
            }
            int ll = l, rr = n - 1;
            while (ll < rr) {
                int m = (ll + rr + 1) / 2;
                if (sum[n - 1] - sum[m] >= sum[m] - sum[i]) {
                    ll = m;
                } else {
                    rr = m - 1;
                }
            }
            ans = (ans + ll - l + 1) % 1000000007;
        }
        return ans;
    }
}