class Solution {
public:
    double maxProbability(int n, vector<vector<int>>& edges, vector<double>& succProb, int start, int end) {
        
        unordered_map<int, vector<pair<int, double>>> graph;
        for (int i = 0; i < edges.size(); i++) {
            graph[edges[i][0]].push_back({edges[i][1], succProb[i]});
            graph[edges[i][1]].push_back({edges[i][0], succProb[i]});
        }
        vector<bool> visited(n, false);
        priority_queue<pair<double, int>> pq;
        pq.push({1.0, start});
        while (!pq.empty()) {
            auto [prob, node] = pq.top();
            pq.pop();
            if (node == end) return prob;
            if (visited[node]) continue;
            visited[node] = true;
            for (auto [next, p] : graph[node]) {
                if (!visited[next]) {
                    pq.push({prob * p, next});
                }
            }
        }
        return 0;
    }
};