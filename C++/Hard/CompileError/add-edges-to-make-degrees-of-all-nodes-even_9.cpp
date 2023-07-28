class Solution {
public:
    bool isPossible(int n, vector<vector<int>>& edges) {
        
        // 1. Count the degree of each node
        vector<int> degree(n + 1, 0);
        for (auto& edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        
        // 2. Count the number of nodes with odd degree
        int oddDegreeNodes = 0;
        for (int i = 1; i <= n; i++) {
            if (degree[i] % 2 == 1) {
                oddDegreeNodes++;
            }
        }
        
        // 3. If there are more than 2 odd degree nodes, then it is not possible to make the degree of each node in the graph even
        if (oddDegreeNodes > 2) {
            return false;
        }
        
        // 4. If there are 2 odd degree nodes, then we need to find a path between them, otherwise we can add 2 edges to make the degree of each node in the graph even
        if (oddDegreeNodes == 2) {
            // 4.1. Build the graph
            vector<vector<int>> graph(n + 1, vector<int>());
            for (auto& edge : edges) {
                graph[edge[0]].push_back(edge[1]);
                graph[edge[1]].push_back(edge[0]);
            }
            
            // 4.2. Find the first odd degree node
            int start = 0;
            for (int i = 1; i <= n; i++) {
                if (degree[i] % 2 == 1) {
                    start = i;
                    break;
                }
            }
            
            // 4.3. Find a path between the first odd degree node and the second odd degree node
            vector<bool> visited(n + 1, false);
            return dfs(graph, start, visited);
        }
        
        return true;
    }
};