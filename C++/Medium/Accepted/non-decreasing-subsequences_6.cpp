class Solution {
public:
    vector<vector<int>> findSubsequences(vector<int>& nums) {
        
        vector<vector<int>> res;
        vector<int> cur;
        findSubsequences(nums, 0, cur, res);
        return res;
    }
    void findSubsequences(vector<int>& nums, int start, vector<int>& cur, vector<vector<int>>& res) {
        if (cur.size() >= 2) {
            res.push_back(cur);
        }
        unordered_set<int> used;
        for (int i = start; i < nums.size(); ++i) {
            if (used.find(nums[i]) != used.end()) {
                continue;
            }
            if (cur.empty() || nums[i] >= cur.back()) {
                used.insert(nums[i]);
                cur.push_back(nums[i]);
                findSubsequences(nums, i + 1, cur, res);
                cur.pop_back();
            }
        }
    }
};