class Solution {
public:
    int waysToBuildRooms(vector<int>& prevRoom) {
        
        int n = prevRoom.size();
        vector<vector<int>> adj(n);
        for (int i = 1; i < n; ++i) {
            adj[prevRoom[i]].push_back(i);
        }
        vector<long> fact(n);
        fact[0] = 1;
        for (int i = 1; i < n; ++i) {
            fact[i] = fact[i - 1] * i % 1000000007;
        }
        vector<int> size(n);
        function<void(int)> dfs = [&](int u) {
            size[u] = 1;
            for (int v : adj[u]) {
                dfs(v);
                size[u] += size[v];
            }
        };
        dfs(0);
        long ans = 1;
        for (int i = 1; i < n; ++i) {
            ans = ans * fact[size[i]] % 1000000007;
        }
        return ans;
    }
};