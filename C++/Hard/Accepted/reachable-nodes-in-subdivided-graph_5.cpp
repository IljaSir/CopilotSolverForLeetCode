class Solution {
public:
    int reachableNodes(vector<vector<int>>& edges, int maxMoves, int n) {
        
        vector<unordered_map<int, int>> graph(n);
        for (auto &e : edges) {
            graph[e[0]][e[1]] = e[2];
            graph[e[1]][e[0]] = e[2];
        }
        priority_queue<pair<int, int>> pq;
        pq.push({maxMoves, 0});
        unordered_map<int, int> seen;
        while (!pq.empty()) {
            auto [moves, i] = pq.top(); pq.pop();
            if (!seen.count(i)) {
                seen[i] = moves;
                for (auto &[j, cnt] : graph[i]) {
                    int moves2 = moves - cnt - 1;
                    if (!seen.count(j) && moves2 >= 0)
                        pq.push({moves2, j});
                }
            }
        }
        int res = seen.size();
        for (auto &e : edges) {
            int a = seen.count(e[0]) ? seen[e[0]] : 0;
            int b = seen.count(e[1]) ? seen[e[1]] : 0;
            res += min(a + b, e[2]);
        }
        return res;
    }
};