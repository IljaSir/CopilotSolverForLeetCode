class Solution {
public:
    vector<double> calcEquation(vector<vector<string>>& equations, vector<double>& values, vector<vector<string>>& queries) {
        
        unordered_map<string, int> table;
        int n = equations.size();
        int m = queries.size();
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (!table.count(equations[i][0])) table[equations[i][0]] = idx++;
            if (!table.count(equations[i][1])) table[equations[i][1]] = idx++;
        }
        vector<vector<double>> g(idx, vector<double>(idx, -1));
        for (int i = 0; i < n; i++) {
            int x = table[equations[i][0]];
            int y = table[equations[i][1]];
            g[x][y] = values[i];
            g[y][x] = 1 / values[i];
        }
        for (int i = 0; i < idx; i++) g[i][i] = 1;
        for (int k = 0; k < idx; k++) {
            for (int i = 0; i < idx; i++) {
                for (int j = 0; j < idx; j++) {
                    if (g[i][k] > 0 && g[k][j] > 0) {
                        g[i][j] = g[i][k] * g[k][j];
                    }
                }
            }
        }
        vector<double> ans(m);
        for (int i = 0; i < m; i++) {
            if (!table.count(queries[i][0]) || !table.count(queries[i][1])) {
                ans[i] = -1;
                continue;
            }
            int x = table[queries[i][0]];
            int y = table[queries[i][1]];
            ans[i] = g[x][y];
        }
        return ans;
    }
};