class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        
        vector<vector<int>> res;
        vector<int> comb;
        combinationSum(candidates, target, 0, comb, res);
        return res;
    }
    void combinationSum(vector<int>& candidates, int target, int start, vector<int>& comb, vector<vector<int>>& res) {
        if (target < 0) return;
        if (target == 0) {
            res.push_back(comb);
            return;
        }
        for (int i = start; i < candidates.size(); i++) {
            comb.push_back(candidates[i]);
            combinationSum(candidates, target - candidates[i], i, comb, res);
            comb.pop_back();
        }
    }
};