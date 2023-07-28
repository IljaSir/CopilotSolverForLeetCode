class Solution {
public:
    vector<vector<int>> findSubsequences(vector<int>& nums) {
        
        vector<vector<int>> res;
        vector<int> cur;
        dfs(nums, 0, cur, res);
        return res;
    }
    void dfs(vector<int>& nums, int index, vector<int>& cur, vector<vector<int>>& res) {
        if (cur.size() >= 2) res.push_back(cur);
        unordered_set<int> us;
        for (int i = index; i < nums.size(); i++) {
            if (us.count(nums[i])) continue;
            if (cur.empty() || nums[i] >= cur.back()) {
                us.insert(nums[i]);
                cur.push_back(nums[i]);
                dfs(nums, i + 1, cur, res);
                cur.pop_back();
            }
        }
    }
};