class Solution {
public:
    vector<vector<int>> findSubsequences(vector<int>& nums) {
        
        vector<vector<int>> res;
        vector<int> path;
        dfs(nums, 0, path, res);
        return res;
    }
    void dfs(vector<int>& nums, int start, vector<int>& path, vector<vector<int>>& res) {
        if (path.size() >= 2) {
            res.push_back(path);
        }
        unordered_set<int> s;
        for (int i = start; i < nums.size(); ++i) {
            if (s.count(nums[i])) {
                continue;
            }
            if (path.empty() || nums[i] >= path.back()) {
                s.insert(nums[i]);
                path.push_back(nums[i]);
                dfs(nums, i + 1, path, res);
                path.pop_back();
            }
        }
    }
};