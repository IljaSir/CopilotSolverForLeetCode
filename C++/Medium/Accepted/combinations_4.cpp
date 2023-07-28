class Solution {
public:
    vector<vector<int>> combine(int n, int k) {
        
        vector<vector<int>> ans;
        vector<int> path;
        dfs(n, k, 1, path, ans);
        return ans;
    }
    void dfs(int n, int k, int start, vector<int> &path, vector<vector<int>> &ans) {
        if (path.size() == k) {
            ans.push_back(path);
            return;
        }
        for (int i = start; i <= n; i++) {
            path.push_back(i);
            dfs(n, k, i + 1, path, ans);
            path.pop_back();
        }
    }
};