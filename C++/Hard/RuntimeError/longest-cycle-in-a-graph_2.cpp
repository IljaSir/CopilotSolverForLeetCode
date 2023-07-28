class Solution {
public:
    int longestCycle(vector<int>& edges) {
        
        int n = edges.size();
        vector<int> dp(n, -1);
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] != -1) continue;
            vector<int> path;
            int j = i;
            while (j != -1 && dp[j] == -1) {
                dp[j] = 0;
                path.push_back(j);
                j = edges[j];
            }
            if (j == -1) continue;
            int k = 0;
            while (path[k] != j) k++;
            res = max(res, (int)path.size() - k);
        }
        return res;
    }
};