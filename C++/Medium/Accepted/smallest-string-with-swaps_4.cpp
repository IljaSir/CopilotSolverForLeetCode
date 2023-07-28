class Solution {
public:
    string smallestStringWithSwaps(string s, vector<vector<int>>& pairs) {
        
        int n = s.size();
        vector<vector<int>> g(n);
        vector<int> vis(n);
        for (auto p : pairs) {
            g[p[0]].push_back(p[1]);
            g[p[1]].push_back(p[0]);
        }
        vector<vector<int>> comps;
        for (int i = 0; i < n; ++i) {
            if (!vis[i]) {
                vector<int> comp;
                dfs(g, vis, i, comp);
                sort(comp.begin(), comp.end());
                comps.push_back(comp);
            }
        }
        for (auto comp : comps) {
            string t = "";
            for (int x : comp) {
                t += s[x];
            }
            sort(t.begin(), t.end());
            for (int i = 0; i < comp.size(); ++i) {
                s[comp[i]] = t[i];
            }
        }
        return s;
    }
    void dfs(vector<vector<int>>& g, vector<int>& vis, int u, vector<int>& comp) {
        if (vis[u]) {
            return;
        }
        vis[u] = 1;
        comp.push_back(u);
        for (int v : g[u]) {
            dfs(g, vis, v, comp);
        }
    }
};