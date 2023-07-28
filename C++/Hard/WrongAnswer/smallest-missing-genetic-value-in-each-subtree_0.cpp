class Solution {
public:
    vector<int> smallestMissingValueSubtree(vector<int>& parents, vector<int>& nums) {
        
        int n = nums.size();
        vector<vector<int>> children(n);
        for (int i = 1; i < n; i++) {
            children[parents[i]].push_back(i);
        }
        vector<int> ans(n);
        vector<int> seen(n+1);
        function<void(int)> dfs = [&](int u) {
            seen[nums[u]] = 1;
            for (int v : children[u]) {
                dfs(v);
            }
            for (int v = 1; v <= n; v++) {
                if (seen[v] == 0) {
                    ans[u] = v;
                    break;
                }
            }
            seen[nums[u]] = 0;
        };
        dfs(0);
        return ans;
    }
};