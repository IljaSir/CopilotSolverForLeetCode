class Solution {
public:
    string smallestStringWithSwaps(string s, vector<vector<int>>& pairs) {
        
        int n = s.size();
        vector<vector<int>> g(n);
        for (auto &p : pairs) {
            g[p[0]].push_back(p[1]);
            g[p[1]].push_back(p[0]);
        }
        vector<bool> vis(n, false);
        for (int i = 0; i < n; ++i) {
            if (!vis[i]) {
                vector<int> comp;
                dfs(i, vis, g, comp);
                sort(comp.begin(), comp.end());
                string t;
                for (int j : comp) {
                    t.push_back(s[j]);
                }
                sort(t.begin(), t.end());
                for (int j = 0; j < comp.size(); ++j) {
                    s[comp[j]] = t[j];
                }
            }
        }
        return s;
    }
    void dfs(int u, vector<bool> &vis, vector<vector<int>> &g, vector<int> &comp) {
        vis[u] = true;
        comp.push_back(u);
        for (int v : g[u]) {
            if (!vis[v]) {
                dfs(v, vis, g, comp);
            }
        }
    }
};