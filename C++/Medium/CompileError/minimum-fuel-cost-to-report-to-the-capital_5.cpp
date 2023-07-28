class Solution {
public:
    long long minimumFuelCost(vector<vector<int>>& roads, int seats) {
        
        int n = roads.size() + 1;
        vector<vector<int>> graph(n);
        for (auto& r : roads) {
            graph[r[0]].push_back(r[1]);
            graph[r[1]].push_back(r[0]);
        }
        vector<int> count(n, 1);
        vector<int> parent(n, -1);
        vector<long long> cost(n, 0);
        dfs(0, graph, count, parent, cost);
        return cost[0];
    }
};