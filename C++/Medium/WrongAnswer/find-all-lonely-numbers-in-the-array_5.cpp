class Solution {
public:
    vector<int> findLonely(vector<int>& nums) {
        
        vector<int> result;
        int i = 0;
        while (i < nums.size()) {
            if (i == 0) {
                if (nums[i] != nums[i+1]) {
                    result.push_back(nums[i]);
                }
            } else if (i == nums.size() - 1) {
                if (nums[i] != nums[i-1]) {
                    result.push_back(nums[i]);
                }
            } else {
                if (nums[i] != nums[i+1] && nums[i] != nums[i-1]) {
                    result.push_back(nums[i]);
                }
            }
            i++;
        }
        return result;
    }
};