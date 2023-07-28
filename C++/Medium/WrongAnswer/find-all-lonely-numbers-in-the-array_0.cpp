class Solution {
public:
    vector<int> findLonely(vector<int>& nums) {
        
        vector<int> lonely;
        for (int i = 0; i < nums.size(); i++) {
            if (i == 0) {
                if (nums[i] != nums[i + 1]) {
                    lonely.push_back(nums[i]);
                }
            } else if (i == nums.size() - 1) {
                if (nums[i - 1] != nums[i]) {
                    lonely.push_back(nums[i]);
                }
            } else {
                if (nums[i - 1] != nums[i] && nums[i] != nums[i + 1]) {
                    lonely.push_back(nums[i]);
                }
            }
        }
        return lonely;
    }
};