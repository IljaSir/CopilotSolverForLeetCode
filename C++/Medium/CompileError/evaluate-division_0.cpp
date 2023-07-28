class Solution {
public:
    vector<double> calcEquation(vector<vector<string>>& equations, vector<double>& values, vector<vector<string>>& queries) {
        
        unordered_map<string, unordered_map<string, double>> graph;
        for (int i = 0; i < equations.size(); i++) {
            graph[equations[i][0]][equations[i][1]] = values[i];
            graph[equations[i][1]][equations[i][0]] = 1 / values[i];
        }
        vector<double> ans;
        for (auto& query: queries) {
            unordered_set<string> visited;
            ans.push_back(dfs(query[0], query[1], graph, visited));
        }
        return ans;
    }
    
    double dfs(string& start, string& end, unordered_map<string, unordered_map<string, double>>& graph, unordered_set<string>& visited) {
        if (!graph.count(start)) return -1.0;
        if (graph[start].count(end)) return graph[start][end];
        visited.insert(start);
        for (auto& [node, val]: graph[start]) {
            if (visited.count(node)) continue;
            double ret = dfs(node, end, graph, visited);
            if (ret != -1.0) return ret * val;
        }
        return -1.0;
    }
};