class Solution {
public:
    vector<string> summaryRanges(vector<int>& nums) {
        
        vector<string> res;
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j + 1 < n && nums[j] + 1 == nums[j + 1]) j++;
            if (i == j) res.push_back(to_string(nums[i]));
            else {
                string s = to_string(nums[i]) + "->" + to_string(nums[j]);
                res.push_back(s);
            }
            i = j;
        }
        return res;
    }
};