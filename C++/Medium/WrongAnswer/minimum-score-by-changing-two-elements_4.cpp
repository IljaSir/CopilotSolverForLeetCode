class Solution {
public:
    int minimizeSum(vector<int>& nums) {
        
        int n = nums.size();
        int ans = INT_MAX;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) {
                        sum += abs(nums[k] - nums[i]);
                    } else {
                        sum += abs(nums[k] - nums[j]);
                    }
                }
                ans = min(ans, sum);
            }
        }
        return ans;
    }
};