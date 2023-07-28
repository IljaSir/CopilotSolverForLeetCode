class Solution {
public:
    int longestCycle(vector<int>& edges) {
        
        int n = edges.size();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int len = 0;
            int j = i;
            while (edges[j] != -1) {
                int k = edges[j];
                edges[j] = -1;
                j = k;
                len++;
            }
            if (j == i && len > 0) {
                res = max(res, len);
            }
        }
        return res == n ? -1 : res;
    }
};