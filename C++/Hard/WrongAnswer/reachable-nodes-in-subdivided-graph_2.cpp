class Solution {
public:
    int reachableNodes(vector<vector<int>>& edges, int maxMoves, int n) {
        
        vector<vector<pair<int, int>>> graph(n);
        for (auto edge : edges) {
            graph[edge[0]].push_back({edge[1], edge[2]});
            graph[edge[1]].push_back({edge[0], edge[2]});
        }
        priority_queue<pair<int, int>> pq;
        pq.push({maxMoves, 0});
        unordered_set<int> visited;
        int res = 0;
        while (!pq.empty()) {
            auto [moves, node] = pq.top();
            pq.pop();
            if (visited.count(node)) continue;
            visited.insert(node);
            res++;
            for (auto [neighbor, edge] : graph[node]) {
                int moves2 = moves - edge - 1;
                if (moves2 >= 0 && !visited.count(neighbor)) {
                    pq.push({moves2, neighbor});
                }
                res += min(moves, edge);
            }
        }
        return res;
    }
};