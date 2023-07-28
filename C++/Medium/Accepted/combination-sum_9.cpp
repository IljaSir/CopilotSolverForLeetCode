class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        
        vector<vector<int>> result;
        vector<int> temp;
        sort(candidates.begin(), candidates.end());
        helper(result, temp, candidates, 0, target);
        return result;
    }
    
    void helper(vector<vector<int>>& result, vector<int>& temp, vector<int>& candidates, int index, int target) {
        if (target == 0) {
            result.push_back(temp);
            return;
        }
        if (target < 0) return;
        for (int i = index; i < candidates.size(); i++) {
            temp.push_back(candidates[i]);
            helper(result, temp, candidates, i, target - candidates[i]);
            temp.pop_back();
        }
    }
};