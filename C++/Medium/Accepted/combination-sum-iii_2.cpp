class Solution {
public:
    vector<vector<int>> combinationSum3(int k, int n) {
        
        vector<vector<int>> res;
        vector<int> path;
        dfs(res, path, k, n, 1);
        return res;
    }
    
    void dfs(vector<vector<int>>& res, vector<int>& path, int k, int n, int start) {
        if (path.size() == k) {
            if (n == 0) {
                res.push_back(path);
            }
            return;
        }
        
        for (int i = start; i <= 9; i++) {
            if (n < i) {
                break;
            }
            path.push_back(i);
            dfs(res, path, k, n - i, i + 1);
            path.pop_back();
        }
    }
};