class Solution {
public:
    int waysToSplit(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> sum(n + 1, 0);
        for (int i = 0; i < n; ++i) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int ans = 0;
        for (int i = 1; i < n - 1; ++i) {
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (sum[m] - sum[i] >= sum[i]) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            if (sum[l] - sum[i] < sum[i]) {
                continue;
            }
            int ll = i + 1;
            int rr = n - 1;
            while (ll < rr) {
                int m = ll + (rr - ll + 1) / 2;
                if (sum[n] - sum[m] >= sum[m] - sum[i]) {
                    ll = m;
                } else {
                    rr = m - 1;
                }
            }
            ans = (ans + ll - l + 1) % 1000000007;
        }
        return ans;
    }
};