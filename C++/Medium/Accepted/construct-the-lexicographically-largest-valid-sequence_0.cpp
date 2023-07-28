class Solution {
public:
    vector<int> constructDistancedSequence(int n) {
        
        vector<int> res(2*n-1, 0);
        vector<bool> used(n+1, false);
        dfs(res, used, 0);
        return res;
    }
    bool dfs(vector<int>& res, vector<bool>& used, int idx) {
        if (idx == res.size()) return true;
        if (res[idx] != 0) return dfs(res, used, idx+1);
        for (int i = used.size()-1; i > 0; --i) {
            if (used[i]) continue;
            if (i != 1 && (idx+i >= res.size() || res[idx+i] != 0)) continue;
            res[idx] = i;
            used[i] = true;
            if (i != 1) res[idx+i] = i;
            if (dfs(res, used, idx+1)) return true;
            res[idx] = 0;
            used[i] = false;
            if (i != 1) res[idx+i] = 0;
        }
        return false;
    }
};