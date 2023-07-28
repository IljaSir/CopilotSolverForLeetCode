class Solution {
public:
    double findMaxAverage(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> sum(n + 1, 0);
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        double ans = INT_MIN;
        for (int i = 0; i + k <= n; i++) {
            ans = max(ans, (double) (sum[i + k] - sum[i]) / k);
        }
        return ans;
    }
};