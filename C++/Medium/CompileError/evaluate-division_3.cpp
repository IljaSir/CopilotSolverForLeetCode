class Solution {
public:
    vector<double> calcEquation(vector<vector<string>>& equations, vector<double>& values, vector<vector<string>>& queries) {
        
        unordered_map<string, unordered_map<string, double>> graph;
        for (int i = 0; i < equations.size(); ++i) {
            graph[equations[i][0]][equations[i][1]] = values[i];
            graph[equations[i][1]][equations[i][0]] = 1.0 / values[i];
        }
        vector<double> result;
        for (auto& query : queries) {
            unordered_set<string> visited;
            result.push_back(dfs(graph, query[0], query[1], visited));
        }
        return result;
    }
    
    double dfs(unordered_map<string, unordered_map<string, double>>& graph, string& start, string& end, unordered_set<string>& visited) {
        if (graph.count(start) == 0 || graph.count(end) == 0) {
            return -1.0;
        }
        if (graph[start].count(end) == 1) {
            return graph[start][end];
        }
        visited.insert(start);
        for (auto& neighbor : graph[start]) {
            if (visited.count(neighbor.first) == 0) {
                double result = dfs(graph, neighbor.first, end, visited);
                if (result != -1.0) {
                    return neighbor.second * result;
                }
            }
        }
        return -1.0;
    }
};