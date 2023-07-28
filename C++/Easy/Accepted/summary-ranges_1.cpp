class Solution {
public:
    vector<string> summaryRanges(vector<int>& nums) {
        
        int n = nums.size();
        vector<string> res;
        if (n == 0) return res;
        int i = 0;
        while (i < n) {
            int j = i + 1;
            while (j < n && nums[j] == nums[j - 1] + 1) j++;
            if (j - i == 1) {
                res.push_back(to_string(nums[i]));
            } else {
                res.push_back(to_string(nums[i]) + "->" + to_string(nums[j - 1]));
            }
            i = j;
        }
        return res;
    }
};