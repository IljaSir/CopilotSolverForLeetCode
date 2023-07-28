class Solution {
public:
    int waysToBuildRooms(vector<int>& prevRoom) {
        
        int n = prevRoom.size();
        vector<vector<int>> adj(n);
        vector<int> indeg(n, 0);
        for(int i = 1; i < n; i++) {
            adj[prevRoom[i]].push_back(i);
            indeg[i]++;
        }
        vector<int> dp(n, 1);
        queue<int> q;
        for(int i = 0; i < n; i++) {
            if(indeg[i] == 0) {
                q.push(i);
            }
        }
        while(!q.empty()) {
            int u = q.front();
            q.pop();
            for(int v : adj[u]) {
                dp[v] = (dp[v] * 1ll * dp[u]) % 1000000007;
                indeg[v]--;
                if(indeg[v] == 0) {
                    q.push(v);
                }
            }
        }
        int ans = 1;
        for(int i = 1; i < n; i++) {
            ans = (ans * 1ll * dp[i]) % 1000000007;
        }
        return ans;
    }
};