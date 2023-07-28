class Solution {
public:
    vector<vector<int>> combine(int n, int k) {
        
        vector<vector<int>> res;
        vector<int> tmp;
        dfs(res, tmp, n, k, 1);
        return res;
    }
    
    void dfs(vector<vector<int>>& res, vector<int>& tmp, int n, int k, int start) {
        if (tmp.size() == k) {
            res.push_back(tmp);
            return;
        }
        
        for (int i = start; i <= n; i++) {
            tmp.push_back(i);
            dfs(res, tmp, n, k, i+1);
            tmp.pop_back();
        }
    }
};