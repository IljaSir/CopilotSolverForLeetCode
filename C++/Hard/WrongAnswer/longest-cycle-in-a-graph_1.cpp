class Solution {
public:
    int longestCycle(vector<int>& edges) {
        
        int n = edges.size();
        vector<int> vis(n, 0);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;
            vis[i] = 1;
            int j = edges[i];
            int cnt = 1;
            while (j != -1 && !vis[j]) {
                vis[j] = 1;
                j = edges[j];
                cnt++;
            }
            if (j == i) {
                ans = max(ans, cnt);
            }
        }
        return ans == 1 ? -1 : ans;
    }
};