class Solution {
public:
    int reachableNodes(int n, vector<vector<int>>& edges, vector<int>& restricted) {
        
        unordered_map<int, unordered_map<int, int>> graph;
        for (auto& e: edges) {
            graph[e[0]][e[1]] = e[2];
            graph[e[1]][e[0]] = e[2];
        }
        unordered_set<int> restrictedSet(restricted.begin(), restricted.end());
        unordered_map<int, int> dist;
        priority_queue<pair<int, int>> pq;
        pq.push({0, 0});
        while (!pq.empty()) {
            auto [d, i] = pq.top();
            pq.pop();
            if (dist.count(i)) continue;
            dist[i] = -d;
            for (auto [j, w]: graph[i]) {
                if (!dist.count(j)) {
                    pq.push({d - w - 1, j});
                }
            }
        }
        int ans = 0;
        for (auto& [i, d]: dist) {
            if (!restrictedSet.count(i)) ++ans;
            for (auto [j, w]: graph[i]) {
                if (dist.count(j)) {
                    int used = d + dist[j] + 1;
                    ans += min(used, w);
                }
            }
        }
        return ans;
    }
};