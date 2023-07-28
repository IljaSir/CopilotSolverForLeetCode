class Solution {
public:
    vector<double> calcEquation(vector<vector<string>>& equations, vector<double>& values, vector<vector<string>>& queries) {
        
        unordered_map<string, unordered_map<string, double>> graph;
        for (int i = 0; i < equations.size(); ++i) {
            graph[equations[i][0]][equations[i][1]] = values[i];
            graph[equations[i][1]][equations[i][0]] = 1 / values[i];
        }
        vector<double> res;
        for (const auto& q : queries) {
            unordered_set<string> visited;
            res.push_back(dfs(graph, q[0], q[1], visited));
        }
        return res;
    }
    double dfs(unordered_map<string, unordered_map<string, double>>& graph, string start, string end, unordered_set<string>& visited) {
        if (visited.count(start)) return -1.0;
        if (graph.count(start) && graph[start].count(end)) return graph[start][end];
        visited.insert(start);
        for (const auto& p : graph[start]) {
            double tmp = dfs(graph, p.first, end, visited);
            if (tmp != -1.0) return tmp * p.second;
        }
        return -1.0;
    }
};