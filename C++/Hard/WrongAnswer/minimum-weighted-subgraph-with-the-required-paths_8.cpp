class Solution {
public:
    long long minimumWeight(int n, vector<vector<int>>& edges, int src1, int src2, int dest) {
        
        vector<vector<int>> graph(n);
        for (auto& e: edges) {
            graph[e[0]].push_back(e[1]);
        }
        vector<int> dist1(n, INT_MAX), dist2(n, INT_MAX);
        dist1[src1] = dist2[src2] = 0;
        queue<int> q1, q2;
        q1.push(src1);
        q2.push(src2);
        while (!q1.empty() || !q2.empty()) {
            if (!q1.empty()) {
                int u = q1.front();
                q1.pop();
                for (int v: graph[u]) {
                    if (dist1[v] > dist1[u] + 1) {
                        dist1[v] = dist1[u] + 1;
                        q1.push(v);
                    }
                }
            }
            if (!q2.empty()) {
                int u = q2.front();
                q2.pop();
                for (int v: graph[u]) {
                    if (dist2[v] > dist2[u] + 1) {
                        dist2[v] = dist2[u] + 1;
                        q2.push(v);
                    }
                }
            }
        }
        long long ans = INT_MAX;
        for (auto& e: edges) {
            int u = e[0], v = e[1], w = e[2];
            if (dist1[u] != INT_MAX && dist2[v] != INT_MAX && dist1[u] + dist2[v] + 1 <= dist1[dest]) {
                ans = min(ans, dist1[u] + dist2[v] + 1LL * w);
            }
            if (dist1[v] != INT_MAX && dist2[u] != INT_MAX && dist1[v] + dist2[u] + 1 <= dist1[dest]) {
                ans = min(ans, dist1[v] + dist2[u] + 1LL * w);
            }
        }
        return ans == INT_MAX ? -1 : ans;
    }
};