class Solution {
public:
    vector<int> maxSumOfThreeSubarrays(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> sum(n+1, 0);
        for (int i = 0; i < n; ++i) {
            sum[i+1] = sum[i] + nums[i];
        }
        vector<int> left(n, 0);
        int best = 0;
        for (int i = k, tot = sum[k] - sum[0]; i < n; ++i) {
            if (sum[i+1] - sum[i+1-k] > tot) {
                tot = sum[i+1] - sum[i+1-k];
                best = i+1-k;
            }
            left[i] = best;
        }
        vector<int> right(n, n-k);
        best = n-k;
        for (int i = n-k-1, tot = sum[n] - sum[n-k]; i >= 0; --i) {
            if (sum[i+k] - sum[i] >= tot) {
                tot = sum[i+k] - sum[i];
                best = i;
            }
            right[i] = best;
        }
        vector<int> ans(3, 0);
        for (int i = k, tot = sum[k] - sum[0]; i <= n-2*k; ++i) {
            int l = left[i-1], r = right[i+k];
            int tot = (sum[i+k] - sum[i]) + (sum[l+k] - sum[l]) + (sum[r+k] - sum[r]);
            if (tot > ans[0] + ans[1] + ans[2]) {
                ans[0] = l;
                ans[1] = i;
                ans[2] = r;
            }
        }
        return ans;
    }
};