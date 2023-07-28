class Solution {
public:
    vector<int> constructDistancedSequence(int n) {
        
        vector<int> ans(2 * n - 1, 0);
        vector<int> used(n + 1, 0);
        dfs(0, n, ans, used);
        return ans;
    }
    bool dfs(int i, int n, vector<int>& ans, vector<int>& used) {
        if (i == ans.size()) return true;
        if (ans[i] != 0) return dfs(i + 1, n, ans, used);
        for (int j = n; j >= 1; --j) {
            if (used[j] || (j != 1 && (i + j >= ans.size() || ans[i + j] != 0))) continue;
            used[j] = 1;
            ans[i] = j;
            if (j != 1) ans[i + j] = j;
            if (dfs(i + 1, n, ans, used)) return true;
            used[j] = 0;
            ans[i] = 0;
            if (j != 1) ans[i + j] = 0;
        }
        return false;
    }
};