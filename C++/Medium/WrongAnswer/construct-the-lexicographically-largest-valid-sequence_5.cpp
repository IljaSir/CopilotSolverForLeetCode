class Solution {
public:
    vector<int> constructDistancedSequence(int n) {
        
        vector<int> ans(2*n-1, 0);
        vector<bool> used(n+1, false);
        if (dfs(ans, used, 0)) return ans;
        return {};
    }
    bool dfs(vector<int>& ans, vector<bool>& used, int i) {
        if (i == ans.size()) return true;
        if (ans[i]) return dfs(ans, used, i+1);
        for (int k = used.size()-1; k >= 1; --k) {
            if (used[k]) continue;
            int j = i+k < ans.size() ? i+k : ans.size()-1-(i+k-ans.size()+1);
            if (ans[j]) continue;
            ans[i] = ans[j] = k;
            used[k] = true;
            if (dfs(ans, used, i+1)) return true;
            ans[i] = ans[j] = 0;
            used[k] = false;
        }
        return false;
    }
};