class Solution {
public:
    vector<vector<int>> combinationSum3(int k, int n) {
        
        vector<vector<int>> res;
        vector<int> comb;
        dfs(k, n, 1, comb, res);
        return res;
    }
    void dfs(int k, int n, int start, vector<int>& comb, vector<vector<int>>& res) {
        if (k == 0 && n == 0) {
            res.push_back(comb);
            return;
        }
        if (k == 0 || n == 0) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            comb.push_back(i);
            dfs(k - 1, n - i, i + 1, comb, res);
            comb.pop_back();
        }
    }
};