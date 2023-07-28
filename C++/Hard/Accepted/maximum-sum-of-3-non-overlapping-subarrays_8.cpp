class Solution {
public:
    vector<int> maxSumOfThreeSubarrays(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> sum(n - k + 1, 0);
        for (int i = 0; i < k; ++i) {
            sum[0] += nums[i];
        }
        for (int i = k; i < n; ++i) {
            sum[i - k + 1] = sum[i - k] - nums[i - k] + nums[i];
        }
        vector<int> left(n - k + 1, 0);
        int best = 0;
        for (int i = 0; i < n - k + 1; ++i) {
            if (sum[i] > sum[best]) {
                best = i;
            }
            left[i] = best;
        }
        vector<int> right(n - k + 1, n - k);
        best = n - k;
        for (int i = n - k; i >= 0; --i) {
            if (sum[i] >= sum[best]) {
                best = i;
            }
            right[i] = best;
        }
        vector<int> ans(3, -1);
        for (int j = k; j < n - 2 * k + 1; ++j) {
            int i = left[j - k], l = right[j + k];
            if (ans[0] == -1 || sum[i] + sum[j] + sum[l] > sum[ans[0]] + sum[ans[1]] + sum[ans[2]]) {
                ans = vector<int>{i, j, l};
            }
        }
        return ans;
    }
};