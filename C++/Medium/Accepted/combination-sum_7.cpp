class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        
        vector<vector<int>> result;
        vector<int> temp;
        dfs(candidates, target, 0, temp, result);
        return result;
    }
    void dfs(vector<int>& candidates, int target, int index, vector<int>& temp, vector<vector<int>>& result) {
        if (target == 0) {
            result.push_back(temp);
            return;
        }
        if (target < 0) return;
        for (int i = index; i < candidates.size(); i++) {
            temp.push_back(candidates[i]);
            dfs(candidates, target - candidates[i], i, temp, result);
            temp.pop_back();
        }
    }
};