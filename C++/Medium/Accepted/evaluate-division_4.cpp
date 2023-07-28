class Solution {
public:
    vector<double> calcEquation(vector<vector<string>>& equations, vector<double>& values, vector<vector<string>>& queries) {
        
        unordered_map<string, unordered_map<string, double>> mp;
        for (int i = 0; i < equations.size(); i++) {
            mp[equations[i][0]][equations[i][1]] = values[i];
            mp[equations[i][1]][equations[i][0]] = 1.0 / values[i];
        }
        
        vector<double> ans;
        for (auto& q : queries) {
            double res = -1.0;
            if (mp.find(q[0]) != mp.end() && mp.find(q[1]) != mp.end()) {
                unordered_set<string> visited;
                res = dfs(q[0], q[1], mp, visited);
            }
            ans.push_back(res);
        }
        return ans;
    }
    
    double dfs(string s, string t, unordered_map<string, unordered_map<string, double>>& mp, unordered_set<string>& visited) {
        if (s == t) return 1.0;
        visited.insert(s);
        for (auto& p : mp[s]) {
            if (visited.find(p.first) == visited.end()) {
                double res = dfs(p.first, t, mp, visited);
                if (res != -1.0) {
                    return res * p.second;
                }
            }
        }
        return -1.0;
    }
};