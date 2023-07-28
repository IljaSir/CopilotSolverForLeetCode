class Solution {
public:
    int numSquarefulPerms(vector<int>& nums) {
        
        int n = nums.size();
        vector<vector<int>> adj(n, vector<int>());
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (is_square(nums[i] + nums[j])) {
                    adj[i].push_back(j);
                    adj[j].push_back(i);
                }
            }
        }
        vector<bool> used(n, false);
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            used[i] = true;
            dfs(nums, adj, used, i, 1, res);
            used[i] = false;
        }
        return res;
    }
    void dfs(vector<int>& nums, vector<vector<int>>& adj, vector<bool>& used, int cur, int count, int& res) {
        if (count == nums.size()) {
            res++;
            return;
        }
        for (int i = 0; i < adj[cur].size(); i++) {
            int next = adj[cur][i];
            if (used[next]) continue;
            if (next > 0 && nums[next] == nums[next - 1] && !used[next - 1]) continue;
            used[next] = true;
            dfs(nums, adj, used, next, count + 1, res);
            used[next] = false;
        }
    }
};