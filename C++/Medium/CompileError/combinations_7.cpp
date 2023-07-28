class Solution {
public:
    vector<vector<int>> combine(int n, int k) {
        
        vector<vector<int>> result;
        vector<int> temp;
        dfs(result, temp, n, k, 1);
        return result;
    }
};