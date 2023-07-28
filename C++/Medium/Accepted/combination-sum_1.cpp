class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        
        vector<vector<int>> res;
        vector<int> tmp;
        dfs(candidates, target, res, tmp, 0);
        return res;
    }
    void dfs(vector<int>& candidates, int target, vector<vector<int>>& res, vector<int>& tmp, int index) {
        if (target == 0) {
            res.push_back(tmp);
            return;
        }
        for (int i = index; i < candidates.size(); i++) {
            if (candidates[i] > target) {
                continue;
            }
            tmp.push_back(candidates[i]);
            dfs(candidates, target - candidates[i], res, tmp, i);
            tmp.pop_back();
        }
    }
};