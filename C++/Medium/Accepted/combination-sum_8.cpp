class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        
        vector<vector<int>> ans;
        vector<int> path;
        sort(candidates.begin(), candidates.end());
        dfs(candidates, target, 0, ans, path);
        return ans;
    }
    
    void dfs(vector<int>& candidates, int target, int index, vector<vector<int>>& ans, vector<int>& path) {
        if (target == 0) {
            ans.push_back(path);
            return;
        }
        for (int i = index; i < candidates.size() && candidates[i] <= target; i++) {
            path.push_back(candidates[i]);
            dfs(candidates, target - candidates[i], i, ans, path);
            path.pop_back();
        }
    }
};