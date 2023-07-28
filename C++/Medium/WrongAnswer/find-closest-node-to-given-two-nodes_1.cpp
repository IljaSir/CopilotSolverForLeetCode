class Solution {
public:
    int closestMeetingNode(vector<int>& edges, int node1, int node2) {
        
        int n = edges.size();
        unordered_map<int, vector<int>> graph;
        for (int i = 0; i < n; ++i) {
            if (edges[i] != -1) {
                graph[i].push_back(edges[i]);
            }
        }
        queue<pair<int, int>> q;
        q.push({node1, 0});
        q.push({node2, 0});
        unordered_set<int> visited;
        int res = INT_MAX;
        while (!q.empty()) {
            auto [node, dist] = q.front();
            q.pop();
            if (visited.count(node)) {
                res = min(res, dist);
            }
            visited.insert(node);
            for (auto& next : graph[node]) {
                q.push({next, dist + 1});
            }
        }
        return res == INT_MAX ? -1 : res;
    }
};