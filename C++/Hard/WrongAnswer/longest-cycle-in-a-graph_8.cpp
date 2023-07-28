class Solution {
public:
    int longestCycle(vector<int>& edges) {
        
        int n = edges.size();
        vector<int> visited(n, -1);
        int res = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            int c = 0;
            while (visited[j] == -1) {
                visited[j] = i;
                j = edges[j];
                c++;
            }
            if (visited[j] == i) {
                res = max(res, c);
            }
        }
        return res == n ? -1 : res;
    }
};