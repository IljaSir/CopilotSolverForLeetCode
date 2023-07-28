class Solution {
public:
    int closestMeetingNode(vector<int>& edges, int node1, int node2) {
        
        int n = edges.size();
        vector<int> dist(n, INT_MAX);
        queue<int> q;
        q.push(node1);
        dist[node1] = 0;
        while (!q.empty()) {
            int u = q.front(); q.pop();
            if (u == node2) break;
            if (edges[u] >= 0 && dist[edges[u]] == INT_MAX) {
                dist[edges[u]] = dist[u] + 1;
                q.push(edges[u]);
            }
        }
        if (dist[node2] != INT_MAX) return node2;
        q.push(node2);
        while (!q.empty()) {
            int u = q.front(); q.pop();
            if (edges[u] >= 0 && dist[edges[u]] == INT_MAX) {
                dist[edges[u]] = dist[u] + 1;
                q.push(edges[u]);
            }
        }
        int ans = -1, maxDist = INT_MIN;
        for (int i = 0; i < n; i++) {
            if (dist[i] != INT_MAX && dist[i] > maxDist) {
                maxDist = dist[i];
                ans = i;
            }
        }
        return ans;
    }
};