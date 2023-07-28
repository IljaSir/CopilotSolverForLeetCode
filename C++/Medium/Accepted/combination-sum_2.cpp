class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        
        vector<vector<int>> res;
        vector<int> path;
        dfs(candidates, target, 0, path, res);
        return res;
    }
    void dfs(vector<int>& candidates, int target, int index, vector<int>& path, vector<vector<int>>& res) {
        if (target == 0) {
            res.push_back(path);
            return;
        }
        for (int i = index; i < candidates.size(); i++) {
            if (candidates[i] > target) continue;
            path.push_back(candidates[i]);
            dfs(candidates, target - candidates[i], i, path, res);
            path.pop_back();
        }
    }
};