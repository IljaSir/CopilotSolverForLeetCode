class Solution {
public:
    vector<double> calcEquation(vector<vector<string>>& equations, vector<double>& values, vector<vector<string>>& queries) {
        
        map<string, map<string, double>> g;
        vector<double> ans;
        int n = values.size();
        for (int i = 0; i < n; i++) {
            string &s1 = equations[i][0];
            string &s2 = equations[i][1];
            g[s1][s2] = values[i];
            g[s2][s1] = 1.0 / values[i];
        }
        for (auto &p: g) {
            string &s1 = p.first;
            for (auto &p1: g[s1]) {
                string &s2 = p1.first;
                double v = p1.second;
                for (auto &p2: g[s2]) {
                    string &s3 = p2.first;
                    double v2 = p2.second;
                    g[s1][s3] = v * v2;
                }
            }
        }
        for (auto &q: queries) {
            string &s1 = q[0];
            string &s2 = q[1];
            if (g.count(s1) && g[s1].count(s2)) {
                ans.push_back(g[s1][s2]);
            } else {
                ans.push_back(-1.0);
            }
        }
        return ans;
    }
};