class Solution {
public:
    double findMaxAverage(vector<int>& nums, int k) {
        
        int n = nums.size();
        double sum = 0, res = 0;
        for (int i = 0; i < n; i++) {
            if (i < k) {
                sum += nums[i];
            } else {
                sum += nums[i] - nums[i - k];
            }
            if (i >= k - 1) {
                res = max(res, sum);
            }
        }
        return res / k;
    }
};