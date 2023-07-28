class Solution {
public:
    vector<double> calcEquation(vector<vector<string>>& equations, vector<double>& values, vector<vector<string>>& queries) {
        
        unordered_map<string, unordered_map<string, double>> graph;
        for (int i = 0; i < equations.size(); ++i) {
            graph[equations[i][0]][equations[i][1]] = values[i];
            graph[equations[i][1]][equations[i][0]] = 1 / values[i];
        }
        vector<double> res;
        for (auto& query : queries) {
            unordered_set<string> visited;
            res.push_back(dfs(query[0], query[1], graph, visited));
        }
        return res;
    }
};