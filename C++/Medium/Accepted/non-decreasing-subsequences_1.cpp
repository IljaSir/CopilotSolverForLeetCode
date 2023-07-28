class Solution {
public:
    vector<vector<int>> findSubsequences(vector<int>& nums) {
        
        vector<vector<int>> res;
        vector<int> out;
        helper(nums, 0, out, res);
        return res;
    }
    void helper(vector<int>& nums, int start, vector<int>& out, vector<vector<int>>& res) {
        if (out.size() >= 2)
            res.push_back(out);
        unordered_set<int> uset;
        for (int i = start; i < nums.size(); ++i) {
            if (uset.find(nums[i]) != uset.end()) continue;
            if (out.empty() || out.back() <= nums[i]) {
                uset.insert(nums[i]);
                out.push_back(nums[i]);
                helper(nums, i + 1, out, res);
                out.pop_back();
            }
        }
    }
};