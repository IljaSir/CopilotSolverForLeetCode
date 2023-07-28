class Solution {
public:
    int longestCycle(vector<int>& edges) {
        
        int n = edges.size();
        vector<int> path(n, 0);
        vector<int> visited(n, 0);
        int max_cycle = 0;
        for (int i = 0; i < n; ++i) {
            if (visited[i] == 0) {
                int cycle = 0;
                int node = i;
                while (visited[node] == 0) {
                    visited[node] = 1;
                    path[node] = cycle++;
                    node = edges[node];
                }
                if (visited[node] == 1) {
                    max_cycle = max(max_cycle, cycle - path[node]);
                    visited[node] = 2;
                }
            }
        }
        return max_cycle;
    }
};