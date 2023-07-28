class Solution {
public:
    int longestCycle(vector<int>& edges) {
        
        vector<int> vis(edges.size(), 0);
        int ans = 0;
        for (int i = 0; i < edges.size(); i++) {
            if (vis[i]) continue;
            int cur = i;
            int len = 0;
            while (edges[cur] != -1 && vis[cur] == 0) {
                vis[cur] = 1;
                cur = edges[cur];
                len++;
            }
            if (edges[cur] == -1) continue;
            if (vis[cur] == 1) {
                ans = max(ans, len);
            }
        }
        return ans;
    }
};