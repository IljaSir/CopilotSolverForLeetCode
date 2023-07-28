class Solution {
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        
        vector<vector<int>> result;
        vector<int> combination;
        sort(candidates.begin(), candidates.end());
        combinationSum2(candidates, target, result, combination, 0);
        return result;
    }
};