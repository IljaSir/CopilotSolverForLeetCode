class Solution {
public:
    int maxAscendingSum(vector<int>& nums) {
        
        int max = 0;
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (i == 0) {
                sum = nums[i];
                continue;
            }
            if (nums[i] > nums[i - 1]) {
                sum += nums[i];
            } else {
                if (sum > max) {
                    max = sum;
                }
                sum = nums[i];
            }
        }
        if (sum > max) {
            max = sum;
        }
        return max;
    }
};