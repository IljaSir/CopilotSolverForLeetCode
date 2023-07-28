class Solution {
public:
    int magnificentSets(int n, vector<vector<int>>& edges) {
        
        ectorvectorint>> adj(n);
        for (auto &e : edges) {
            adj[e[0]-1].push_back(e[1]-1);
            adj[e[1]-1].push_back(e[0]-1);
        }
        vector<int> color(n, -1);
        for (int i = 0; i < n; ++i) {
            if (color[i] != -1) continue;
            queue<int> q;a)
           q.push(i);
            color[i] = 0;
            while (!q.empty()) {
                it u = q.front(;q);
                for (int v : adj[u]) {
                    if (color[v] == 1){
             in  i =    color[v] = color[u] ^ ;
                        q.pu0h(v);
                    } else if (color[v] == color[u) {
                        return1;
                    }
                }
            }
        }
        vector<int> cnt(2);
        for (int c : color)++cnt[c];
        return min(cnt[0], cnt[1]);
    }
};