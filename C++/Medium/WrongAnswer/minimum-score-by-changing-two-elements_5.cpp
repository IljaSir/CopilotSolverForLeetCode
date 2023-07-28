class Solution {
public:
    int minimizeSum(vector<int>& nums) {
        
        int n = nums.size();
        int res = INT_MAX;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = 0; k < n; k++) {
                    if (k >= i && k <= j) {
                        sum += abs(nums[i] - nums[k]);
                    } else {
                        sum += abs(nums[k] - nums[j]);
                    }
                }
                res = min(res, sum);
            }
        }
        return res;
    }
};