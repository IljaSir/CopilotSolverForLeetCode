class Solution {
public:
    vector<int> constructDistancedSequence(int n) {
        
        vector<int> ans(2 * n - 1, 0);
        dfs(ans, n, 0);
        return ans;
    }
    bool dfs(vector<int>& ans, int n, int start) {
        if (start == ans.size()) {
            return true;
        }
        if (ans[start] != 0) {
            return dfs(ans, n, start + 1);
        }
        for (int i = n; i >= 1; --i) {
            if (i == 1 || ans[start] == 0 && (start + i < ans.size() && ans[start + i] == 0 || start + i == ans.size())) {
                ans[start] = i;
                if (i != 1) {
                    ans[start + i] = i;
                }
                if (dfs(ans, n, start + 1)) {
                    return true;
                }
                ans[start] = 0;
                if (i != 1) {
                    ans[start + i] = 0;
                }
            }
        }
        return false;
    }
};