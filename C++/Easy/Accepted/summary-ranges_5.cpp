class Solution {
public:
    vector<string> summaryRanges(vector<int>& nums) {
        
        vector<string> res;
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j + 1 < n && nums[j] == nums[j + 1] - 1) j++;
            if (i == j) res.push_back(to_string(nums[i]));
            else res.push_back(to_string(nums[i]) + "->" + to_string(nums[j]));
            i = j;
        }
        return res;
    }
};