class Solution {
public:
    int findClosestNumber(vector<int>& nums) {
        
        int min = 1000000;
        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (abs(nums[i]) < min) {
                min = abs(nums[i]);
                res = nums[i];
            }
            else if (abs(nums[i]) == min) {
                if (nums[i] > res)
                    res = nums[i];
            }
        }
        return res;
    }
};