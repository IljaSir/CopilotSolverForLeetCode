class Solution {
public:
    vector<int> constructDistancedSequence(int n) {
        
        vector<int> ans(2 * n - 1, 0);
        vector<int> used(n + 1, 0);
        dfs(ans, used, 0);
        return ans;
    }
    
    bool dfs(vector<int>& ans, vector<int>& used, int pos) {
        if (pos == ans.size()) return true;
        if (ans[pos] != 0) return dfs(ans, used, pos + 1);
        for (int i = used.size() - 1; i >= 1; --i) {
            if (used[i] == 2) continue;
            if (i > 1 && (pos + i >= ans.size() || ans[pos + i] != 0)) continue;
            ans[pos] = i;
            if (i > 1) ans[pos + i] = i;
            ++used[i];
            if (dfs(ans, used, pos + 1)) return true;
            ans[pos] = 0;
            if (i > 1) ans[pos + i] = 0;
            --used[i];
        }
        return false;
    }
};