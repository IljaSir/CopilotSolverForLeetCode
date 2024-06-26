class Solution {
public:
    vector<string> summaryRanges(vector<int>& nums) {
        
        vector<string> result;
        int i = 0;
        while (i < nums.size()) {
            int j = i + 1;
            while (j < nums.size() && nums[j] - nums[j-1] == 1) {
                j++;
            }
            if (j - 1 > i) {
                result.push_back(to_string(nums[i]) + "->" + to_string(nums[j-1]));
            } else {
                result.push_back(to_string(nums[i]));
            }
            i = j;
        }
        return result;
    }
};