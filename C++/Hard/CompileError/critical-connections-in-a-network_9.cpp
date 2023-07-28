class Solution {
public:
    vector<vector<int>> criticalConnections(int n, vector<vector<int>>& connections) {
        
		vector<vector<int>> res;
		vector<int> visited(n, -1);
		vector<int> low(n, 0);
		vector<vector<int>> graph(n);
		for (auto& e: connections) {
			graph[e[0]].push_back(e[1]);
			graph[e[1]].push_back(e[0]);
		}
		dfs(0, 0, visited, low, graph, res);
		return res;
    }
};