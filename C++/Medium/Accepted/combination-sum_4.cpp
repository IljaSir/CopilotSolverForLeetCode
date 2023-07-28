class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        
        vector<vector<int>> res;
        vector<int> path;
        backtrack(candidates, target, res, path, 0);
        return res;
    }
    
    void backtrack(vector<int>& candidates, int target, vector<vector<int>>& res, vector<int>& path, int start) {
        if (target < 0) return;
        if (target == 0) {
            res.push_back(path);
            return;
        }
        for (int i = start; i < candidates.size(); i++) {
            path.push_back(candidates[i]);
            backtrack(candidates, target - candidates[i], res, path, i);
            path.pop_back();
        }
    }
};