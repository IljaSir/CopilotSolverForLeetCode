class Solution {
public:
    double findMaxAverage(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> sums(n + 1);
        for (int i = 0; i < n; ++i) {
            sums[i + 1] = sums[i] + nums[i];
        }
        double res = INT_MIN;
        for (int i = k; i <= n; ++i) {
            res = max(res, (sums[i] - sums[i - k]) * 1.0 / k);
        }
        return res;
    }
};