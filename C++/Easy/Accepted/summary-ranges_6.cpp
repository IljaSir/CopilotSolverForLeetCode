class Solution {
public:
    vector<string> summaryRanges(vector<int>& nums) {
        
        vector<string> result;
        if (nums.empty()) {
            return result;
        }
        int n = nums.size();
        int i = 0;
        while (i < n) {
            int j = i + 1;
            while (j < n && nums[j] == nums[j - 1] + 1) {
                ++j;
            }
            if (j == i + 1) {
                result.push_back(to_string(nums[i]));
            } else {
                result.push_back(to_string(nums[i]) + "->" + to_string(nums[j - 1]));
            }
            i = j;
        }
        return result;
    }
};