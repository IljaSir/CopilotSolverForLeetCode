class Solution {
public:
    vector<vector<int>> combinationSum3(int k, int n) {
        
        vector<vector<int>> res;
        vector<int> path;
        dfs(1, k, n, path, res);
        return res;
    }
    void dfs(int start, int k, int n, vector<int> &path, vector<vector<int>> &res) {
        if (k == 0 && n == 0) {
            res.push_back(path);
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (n < i) break;
            path.push_back(i);
            dfs(i+1, k-1, n-i, path, res);
            path.pop_back();
        }
    }
};