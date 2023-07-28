class Solution {
public:
    int reachableNodes(vector<vector<int>>& edges, int maxMoves, int n) {
        
        vector<vector<pair<int, int>>> graph(n);
        for (auto& edge : edges) {
            graph[edge[0]].push_back({edge[1], edge[2]});
            graph[edge[1]].push_back({edge[0], edge[2]});
        }
        priority_queue<pair<int, int>> pq;
        pq.push({maxMoves, 0});
        vector<int> seen(n);
        while (!pq.empty()) {
            auto [moves, node] = pq.top();
            pq.pop();
            if (seen[node]) continue;
            seen[node] = moves + 1;
            for (auto [next, nextMoves] : graph[node]) {
                if (seen[next] <= moves - nextMoves - 1) {
                    pq.push({moves - nextMoves - 1, next});
                }
            }
        }
        int ans = accumulate(begin(seen), end(seen), 0);
        for (auto& edge : edges) {
            ans -= max(0, seen[edge[0]] + seen[edge[1]] - edge[2] - 1);
        }
        return ans;
    }
};