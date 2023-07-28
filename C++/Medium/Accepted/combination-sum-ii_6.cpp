class Solution {
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        
        vector<vector<int>> result;
        vector<int> combination;
        sort(candidates.begin(), candidates.end());
        dfs(candidates, 0, target, combination, result);
        return result;
    }
    
    void dfs(vector<int>& candidates, int begin, int target, vector<int>& combination, vector<vector<int>>& result) {
        if (target == 0) {
            result.push_back(combination);
            return;
        }
        
        for (int i = begin; i < candidates.size() && target >= candidates[i]; i++) {
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            combination.push_back(candidates[i]);
            dfs(candidates, i + 1, target - candidates[i], combination, result);
            combination.pop_back();
        }
    }
};