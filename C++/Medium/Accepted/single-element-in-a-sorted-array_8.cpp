class Solution {
public:
    int singleNonDuplicate(vector<int>& nums) {
        
        int len = nums.size();
        int i = 0;
        while (i < len) {
            if (i == len - 1) {
                return nums[i];
            }
            if (nums[i] == nums[i + 1]) {
                i += 2;
            } else {
                return nums[i];
            }
        }
        return nums[i];
    }
};