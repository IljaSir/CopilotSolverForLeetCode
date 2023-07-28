class Solution {
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        
        vector<vector<int>> res;
        vector<int> path;
        sort(candidates.begin(), candidates.end());
        dfs(candidates, 0, path, target, res);
        return res;
    }
    void dfs(vector<int>& candidates, int u, vector<int>& path, int target, vector<vector<int>>& res) {
        if (target == 0) {
            res.push_back(path);
            return;
        }
        for (int i = u; i < candidates.size(); ++i) {
            if (i > u && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > target) break;
            path.push_back(candidates[i]);
            dfs(candidates, i + 1, path, target - candidates[i], res);
            path.pop_back();
        }
    }
};