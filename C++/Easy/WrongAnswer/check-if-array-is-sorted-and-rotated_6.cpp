class Solution {
public:
    bool check(vector<int>& nums) {
        
        int i = 0;
        while (i < nums.size() && nums[i] <= nums[0]) {
            i++;
        }
        while (i < nums.size() && nums[i] >= nums[0]) {
            i++;
        }
        return i == nums.size();
    }
};