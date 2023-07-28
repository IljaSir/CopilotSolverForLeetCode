class Solution {
public:
    int rangeSum(vector<int>& nums, int n, int left, int right) {
        
        vector<long> sum(n, 0);
        for (int i = 0; i < n; ++i) {
            sum[i] = nums[i];
            if (i > 0) sum[i] += sum[i-1];
        }
        vector<long> sums;
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                sums.push_back(sum[j] - (i > 0 ? sum[i-1] : 0));
            }
        }
        sort(sums.begin(), sums.end());
        long ans = 0;
        for (int i = left - 1; i < right; ++i) {
            ans += sums[i];
        }
        return ans % 1000000007;
    }
};