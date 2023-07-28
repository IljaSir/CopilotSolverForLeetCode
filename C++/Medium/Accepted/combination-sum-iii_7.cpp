class Solution {
public:
    vector<vector<int>> combinationSum3(int k, int n) {
        
        vector<vector<int>> ans;
        vector<int> path;
        dfs(k, n, 1, ans, path);
        return ans;
    }
    void dfs(int k, int n, int start, vector<vector<int>>& ans, vector<int>& path) {
        if (k == 0 && n == 0) {
            ans.push_back(path);
            return;
        }
        for (int i = start; i <= 9; i++) {
            path.push_back(i);
            dfs(k - 1, n - i, i + 1, ans, path);
            path.pop_back();
        }
    }
};