class Solution {
public:
    int maxSumMinProduct(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> l(n), r(n);
        for (int i = 0; i < n; ++i) {
            l[i] = i;
            while (l[i] > 0 && nums[l[i] - 1] >= nums[i]) {
                l[i] = l[l[i] - 1];
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            r[i] = i;
            while (r[i] < n - 1 && nums[r[i] + 1] >= nums[i]) {
                r[i] = r[r[i] + 1];
            }
        }
        vector<int> sum(n + 1);
        for (int i = 1; i <= n; ++i) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            res = max(res, nums[i] * (sum[r[i] + 1] - sum[l[i]]));
        }
        return res % 1000000007;
    }
};