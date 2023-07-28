class Solution {
public:
    vector<vector<int>> combinationSum3(int k, int n) {
        
        vector<vector<int>> res;
        vector<int> path;
        dfs(res, path, k, n, 1);
        return res;
    }
    void dfs(vector<vector<int>>& res, vector<int>& path, int k, int n, int start) {
        if (n < 0 || path.size() > k) return;
        if (n == 0 && path.size() == k) {
            res.push_back(path);
            return;
        }
        for (int i = start; i <= 9; i++) {
            path.push_back(i);
            dfs(res, path, k, n - i, i + 1);
            path.pop_back();
        }
    }
};