class Solution {
public:
    int longestCycle(vector<int>& edges) {
        
        int n = edges.size();
        vector<int> visited(n, 0);
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                int cur = i;
                int step = 0;
                while (edges[cur] != -1 && visited[cur] == 0) {
                    visited[cur] = 1;
                    cur = edges[cur];
                    step++;
                }
                if (edges[cur] == -1) {
                    continue;
                }
                if (visited[cur] == 1) {
                    res = max(res, step + 1);
                }
                cur = edges[cur];
                step++;
                while (cur != i) {
                    cur = edges[cur];
                    step++;
                }
                res = max(res, step);
            }
        }
        return res;
    }
};