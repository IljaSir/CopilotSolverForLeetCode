class Solution {
public:
    int numSquarefulPerms(vector<int>& nums) {
        
        int n = nums.size();
        vector<vector<int>> adj(n, vector<int>(n, 0));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = nums[i] + nums[j];
                int y = sqrt(x);
                if (y*y == x) {
                    adj[i][j] = 1;
                }
            }
        }
        vector<int> perm(n, 0);
        vector<int> used(n, 0);
        int res = 0;
        function<void(int)> dfs = [&](int k) {
            if (k == n) {
                res++;
                return;
            }
            for (int i = 0; i < n; i++) {
                if (used[i] || (k > 0 && adj[perm[k-1]][i] == 0)) {
                    continue;
                }
                used[i] = 1;
                perm[k] = i;
                dfs(k + 1);
                used[i] = 0;
            }
        };
        dfs(0);
        return res;
    }
};