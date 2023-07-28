class Solution {
public:
    vector<int> findLonely(vector<int>& nums) {
        
        vector<int> lonely;
        for (int i = 0; i < nums.size(); i++) {
            int pre = i - 1;
            int post = i + 1;
            bool lonely = true;
            if (pre >= 0 && nums[pre] == nums[i]) {
                lonely = false;
            }
            if (post < nums.size() && nums[post] == nums[i]) {
                lonely = false;
            }
            if (lonely) {
                lonely.push_back(nums[i]);
            }
        }
        return lonely;
    }
};