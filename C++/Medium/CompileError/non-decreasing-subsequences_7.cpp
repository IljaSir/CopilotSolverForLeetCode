class Solution {
public:
    vector<vector<int>> findSubsequences(vector<int>& nums) {
        
        vector<vector<int>> res;
        vector<int> temp;
        dfs(res, temp, nums, 0);
        return res;
    }
};