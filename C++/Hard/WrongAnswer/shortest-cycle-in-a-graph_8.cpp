class Solution {
public:
    int findShortestCycle(int n, vector<vector<int>>& edges) {
        
        int m = edges.size();
        vector<vector<int>> adj(n);
        for(auto& e : edges) {
            adj[e[0]].push_back(e[1]);
            adj[e[1]].push_back(e[0]);
        }
        vector<int> dist(n, -1);
        vector<int> vis(n, 0);
        vector<int> par(n, -1);
        int ans = INT_MAX;
        for(int i = 0; i < n; i++) {
            if(vis[i]) continue;
            queue<int> q;
            q.push(i);
            dist[i] = 0;
            vis[i] = 1;
            while(!q.empty()) {
                int u = q.front();
                q.pop();
                for(int v : adj[u]) {
                    if(!vis[v]) {
                        dist[v] = dist[u] + 1;
                        vis[v] = 1;
                        par[v] = u;
                        q.push(v);
                    }
                    else if(v != par[u]) {
                        ans = min(ans, dist[u] + dist[v] + 1);
                    }
                }
            }
        }
        return ans == INT_MAX ? -1 : ans;
    }
};