class Solution {
public:
    int maxAscendingSum(vector<int>& nums) {
        
        int sum = 0;
        int max = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                sum += nums[i];
                if (sum > max) {
                    max = sum;
                }
            } else {
                sum = nums[i];
            }
        }
        return max;
    }
};