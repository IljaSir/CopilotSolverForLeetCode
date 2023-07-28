class Solution {
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        
        vector<vector<int>> res;
        vector<int> cur;
        sort(candidates.begin(), candidates.end());
        dfs(res, cur, candidates, 0, target);
        return res;
    }
    void dfs(vector<vector<int>> &res, vector<int> &cur, vector<int> &candidates, int idx, int target) {
        if (target == 0) {
            res.push_back(cur);
            return;
        }
        for (int i = idx; i < candidates.size(); i++) {
            if (target < candidates[i]) return;
            if (i > idx && candidates[i] == candidates[i - 1]) continue;
            cur.push_back(candidates[i]);
            dfs(res, cur, candidates, i + 1, target - candidates[i]);
            cur.pop_back();
        }
    }
};