class Solution {
public:
    vector<double> calcEquation(vector<vector<string>>& equations, vector<double>& values, vector<vector<string>>& queries) {
        
        int n = equations.size();
        unordered_map<string, unordered_map<string, double>> g;
        for (int i = 0; i < n; i++) {
            string a = equations[i][0], b = equations[i][1];
            g[a][b] = values[i];
            g[b][a] = 1 / values[i];
        }
        vector<double> res;
        for (auto& q : queries) {
            string a = q[0], b = q[1];
            if (!g.count(a) || !g.count(b)) {
                res.push_back(-1.0);
                continue;
            }
            unordered_set<string> visited;
            double ans = dfs(g, a, b, visited);
            res.push_back(ans);
        }
        return res;
    }
};