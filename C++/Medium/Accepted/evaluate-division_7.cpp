class Solution {
public:
    vector<double> calcEquation(vector<vector<string>>& equations, vector<double>& values, vector<vector<string>>& queries) {
        
        vector<double> res;
        unordered_map<string, unordered_map<string, double>> graph;
        for(int i = 0; i < equations.size(); i++) {
            graph[equations[i][0]][equations[i][1]] = values[i];
            graph[equations[i][1]][equations[i][0]] = 1.0 / values[i];
        }
        for(auto& it : graph) {
            it.second[it.first] = 1.0;
            unordered_set<string> visited;
            dfs(it.first, it.first, graph, visited);
        }
        for(auto& query : queries) {
            if(graph.count(query[0]) && graph[query[0]].count(query[1]))
                res.push_back(graph[query[0]][query[1]]);
            else
                res.push_back(-1.0);
        }
        return res;
    }
    void dfs(string start, string cur, unordered_map<string, unordered_map<string, double>>& graph, unordered_set<string>& visited) {
        visited.insert(cur);
        for(auto& it : graph[cur]) {
            if(visited.count(it.first))
                continue;
            graph[start][it.first] = graph[start][cur] * graph[cur][it.first];
            dfs(start, it.first, graph, visited);
        }
    }
};