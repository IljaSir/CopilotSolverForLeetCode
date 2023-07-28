class Solution {
public:
    vector<vector<int>> combine(int n, int k) {
        
        vector<vector<int>> res;
        vector<int> v;
        dfs(n, k, 1, v, res);
        return res;
    }
    void dfs(int n, int k, int idx, vector<int> &v, vector<vector<int>> &res) {
        if (v.size() == k) {
            res.push_back(v);
            return;
        }
        for (int i = idx; i <= n; i++) {
            v.push_back(i);
            dfs(n, k, i + 1, v, res);
            v.pop_back();
        }
    }
};