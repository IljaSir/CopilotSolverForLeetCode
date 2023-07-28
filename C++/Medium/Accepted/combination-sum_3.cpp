class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        
        vector<vector<int>> ans;
        vector<int> cur;
        sort(candidates.begin(), candidates.end());
        dfs(ans, cur, candidates, target, 0);
        return ans;
    }
    void dfs(vector<vector<int>>& ans, vector<int>& cur, vector<int>& candidates, int target, int start) {
        if (target == 0) {
            ans.push_back(cur);
            return;
        }
        for (int i = start; i < candidates.size() && candidates[i] <= target; i++) {
            cur.push_back(candidates[i]);
            dfs(ans, cur, candidates, target - candidates[i], i);
            cur.pop_back();
        }
    }
};