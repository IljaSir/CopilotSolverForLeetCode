class Solution {
public:
    int closestMeetingNode(vector<int>& edges, int node1, int node2) {
        
        int n = edges.size();
        vector<int> dist(n, INT_MAX);
        queue<int> q;
        q.push(node1);
        dist[node1] = 0;
        while(!q.empty()) {
            int u = q.front();
            q.pop();
            if(edges[u] != -1) {
                if(dist[edges[u]] == INT_MAX) {
                    dist[edges[u]] = dist[u] + 1;
                    q.push(edges[u]);
                }
            }
        }
        q.push(node2);
        dist[node2] = 0;
        while(!q.empty()) {
            int u = q.front();
            q.pop();
            if(edges[u] != -1) {
                if(dist[edges[u]] == INT_MAX) {
                    dist[edges[u]] = dist[u] + 1;
                    q.push(edges[u]);
                }
            }
        }
        int ans = -1;
        int maxDist = INT_MIN;
        for(int i = 0; i < n; i++) {
            if(dist[i] != INT_MAX) {
                if(dist[i] > maxDist) {
                    maxDist = dist[i];
                    ans = i;
                }
            }
        }
        return ans;
    }
};