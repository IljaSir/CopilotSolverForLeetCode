class Solution {
public:
    vector<double> calcEquation(vector<vector<string>>& equations, vector<double>& values, vector<vector<string>>& queries) {
        
        unordered_map<string, unordered_map<string, double>> graph;
        for (int i = 0; i < equations.size(); i++) {
            graph[equations[i][0]].insert({equations[i][1], values[i]});
            graph[equations[i][1]].insert({equations[i][0], 1 / values[i]});
        }
        vector<double> res;
        for (auto &q: queries) {
            if (graph.find(q[0]) == graph.end() || graph.find(q[1]) == graph.end())
                res.push_back(-1);
            else {
                unordered_set<string> visited;
                res.push_back(dfs(graph, q[0], q[1], visited));
            }
        }
        return res;
    }
    
    double dfs(unordered_map<string, unordered_map<string, double>> &graph, string &start, string &end, unordered_set<string> &visited) {
        if (start == end) return 1;
        visited.insert(start);
        for (auto &p: graph[start]) {
            if (visited.find(p.first) == visited.end()) {
                double d = dfs(graph, p.first, end, visited);
                if (d != -1) return d * p.second;
            }
        }
        return -1;
    }
};