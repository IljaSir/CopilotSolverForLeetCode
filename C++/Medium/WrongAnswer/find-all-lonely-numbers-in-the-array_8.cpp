class Solution {
public:
    vector<int> findLonely(vector<int>& nums) {
        
        vector<int> lonely;
        int i = 0;
        while (i < nums.size()) {
            if (i == 0 && nums.size() > 1 && nums[i] != nums[i + 1]) {
                lonely.push_back(nums[i]);
            } else if (i == nums.size() - 1 && nums[i] != nums[i - 1]) {
                lonely.push_back(nums[i]);
            } else if (i > 0 && i < nums.size() - 1 && nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                lonely.push_back(nums[i]);
            }
            i++;
        }
        return lonely;
    }
};