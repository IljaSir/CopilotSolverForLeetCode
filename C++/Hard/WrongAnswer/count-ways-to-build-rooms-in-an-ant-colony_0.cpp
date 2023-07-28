class Solution {
public:
    int waysToBuildRooms(vector<int>& prevRoom) {
        
        int n = prevRoom.size();
        vector<vector<int>> g(n);
        for (int i = 1; i < n; ++i) {
            g[prevRoom[i]].push_back(i);
        }
        vector<int> f(n, 1), s(n, 1);
        function<void(int)> dfs = [&](int u) {
            for (int v : g[u]) {
                dfs(v);
                s[u] = (long long)s[u] * s[v] % 1000000007;
                f[u] = (long long)f[u] * f[v] % 1000000007 * ++s[v] % 1000000007;
            }
        };
        dfs(0);
        return f[0];
    }
};