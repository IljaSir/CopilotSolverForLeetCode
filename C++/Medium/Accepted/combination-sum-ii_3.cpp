class Solution {
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        
        vector<vector<int>> result;
        vector<int> combination;
        sort(candidates.begin(), candidates.end());
        dfs(candidates, target, 0, combination, result);
        return result;
    }
    void dfs(vector<int>& candidates, int target, int startIndex, vector<int>& combination, vector<vector<int>>& result) {
        if (target == 0) {
            result.push_back(combination);
            return;
        }
        for (int i = startIndex; i < candidates.size() && target >= candidates[i]; i++) {
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            combination.push_back(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1, combination, result);
            combination.pop_back();
        }
    }
};