class Solution {
public:
    long long minimumFuelCost(vector<vector<int>>& roads, int seats) {
        
        int n = roads.size() + 1;
        vector<vector<int>> adj(n);
        vector<int> degree(n);
        for (auto& road : roads) {
            adj[road[0]].push_back(road[1]);
            adj[road[1]].push_back(road[0]);
            degree[road[0]]++;
            degree[road[1]]++;
        }
        vector<int> leaf;
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                leaf.push_back(i);
            }
        }
        vector<int> count(n);
        vector<long long> cost(n);
        for (int i = n - 1; i >= 0; i--) {
            int u = leaf[i];
            count[u] = 1;
            cost[u] = 0;
            for (int v : adj[u]) {
                if (degree[v] == 1) {
                    continue;
                }
                count[u] += count[v];
                cost[u] += cost[v];
                cost[u] += count[v];
            }
            if (count[u] > seats) {
                cost[u] += count[u] - seats;
                count[u] = seats;
            }
        }
        return cost[0];
    }
};