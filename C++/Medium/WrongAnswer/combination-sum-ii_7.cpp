class Solution {
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        
        vector<vector<int>> ret;
        vector<int> cur;
        sort(candidates.begin(), candidates.end());
        dfs(candidates, 0, target, cur, ret);
        return ret;
    }
    void dfs(vector<int>& candidates, int pos, int target, vector<int>& cur, vector<vector<int>>& ret) {
        if (target == 0) {
            ret.push_back(cur);
            return;
        }
        if (pos >= candidates.size() || target < 0) {
            return;
        }
        int next = pos + 1;
        while (next < candidates.size() && candidates[next] == candidates[next - 1]) {
            next++;
        }
        dfs(candidates, next, target, cur, ret);
        for (int i = pos; i < next; i++) {
            cur.push_back(candidates[i]);
            dfs(candidates, next, target - candidates[i], cur, ret);
        }
        cur.erase(cur.end() - (next - pos), cur.end());
    }
};