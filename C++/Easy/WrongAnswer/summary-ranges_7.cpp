class Solution {
public:
    vector<string> summaryRanges(vector<int>& nums) {
        
        vector<string> res;
        if (nums.empty()) return res;
        int n = nums.size();
        int i = 0;
        int j = 1;
        while (j < n) {
            while (j < n && nums[j] == nums[j - 1] + 1) ++j;
            if (i == j - 1) res.push_back(to_string(nums[i]));
            else res.push_back(to_string(nums[i]) + "->" + to_string(nums[j - 1]));
            i = j++;
        }
        if (i == j - 1) res.push_back(to_string(nums[i]));
        else res.push_back(to_string(nums[i]) + "->" + to_string(nums[j - 1]));
        return res;
    }
};