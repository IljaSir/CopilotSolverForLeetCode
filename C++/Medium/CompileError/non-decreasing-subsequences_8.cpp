class Solution {
public:
    vector<vector<int>> findSubsequences(vector<int>& nums) {
        
        vector<vector<int>> ans;
        vector<int> seq;
        dfs(nums, ans, seq, 0);
        return ans;
    }
};