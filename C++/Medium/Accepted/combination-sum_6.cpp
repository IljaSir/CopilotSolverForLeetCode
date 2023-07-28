class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        
        vector<vector<int>> ans;
        vector<int> cur;
        dfs(candidates, target, 0, cur, ans);
        return ans;
    }
    void dfs(vector<int>& candidates, int target, int start, vector<int>& cur, vector<vector<int>>& ans) {
        if (target == 0) {
            ans.push_back(cur);
            return;
        }
        for (int i = start; i < candidates.size(); i++) {
            if (candidates[i] > target) continue;
            cur.push_back(candidates[i]);
            dfs(candidates, target - candidates[i], i, cur, ans);
            cur.pop_back();
        }
    }
};