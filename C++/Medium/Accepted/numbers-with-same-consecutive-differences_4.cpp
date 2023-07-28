class Solution {
public:
    vector<int> numsSameConsecDiff(int n, int k) {
        
        vector<int> ans;
        if (n == 1) ans.push_back(0);
        for (int i = 1; i <= 9; i++) {
            dfs(i, n - 1, k, ans);
        }
        return ans;
    }
    void dfs(int cur, int n, int k, vector<int>& ans) {
        if (n == 0) {
            ans.push_back(cur);
            return;
        }
        int last = cur % 10;
        if (last + k <= 9) dfs(cur * 10 + last + k, n - 1, k, ans);
        if (last - k >= 0 && k != 0) dfs(cur * 10 + last - k, n - 1, k, ans);
    }
};