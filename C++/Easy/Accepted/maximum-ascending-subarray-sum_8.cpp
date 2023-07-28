class Solution {
public:
    int maxAscendingSum(vector<int>& nums) {
        
        int n = nums.size();
        int sum = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (i + 1 < n && nums[i] >= nums[i + 1]) {
                res = max(res, sum);
                sum = 0;
            }
        }
        return max(res, sum);
    }
};