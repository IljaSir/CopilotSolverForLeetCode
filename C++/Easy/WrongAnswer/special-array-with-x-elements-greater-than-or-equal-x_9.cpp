class Solution {
public:
    int specialArray(vector<int>& nums) {
        
        std::sort(nums.begin(), nums.end());
        int prev = -1;
        for (int i = 0; i < nums.size(); ++i) {
            if (nums[i] != prev && nums.size() - i == nums[i]) {
                return nums[i];
            }
            prev = nums[i];
        }
        return -1;
    }
};