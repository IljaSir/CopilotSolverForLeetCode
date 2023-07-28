class Solution {
public:
    double findMaxAverage(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> sum(n+1, 0);
        for (int i = 1; i <= n; ++i) {
            sum[i] = sum[i-1] + nums[i-1];
        }
        double res = INT_MIN;
        for (int i = k; i <= n; ++i) {
            res = max(res, 1.0 * (sum[i] - sum[i-k]) / k);
        }
        return res;
    }
};