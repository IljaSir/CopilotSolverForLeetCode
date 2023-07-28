class Solution {
public:
    int findCenter(vector<vector<int>>& edges) {
        
        int n = edges.size();
        vector<int> v(n+2, 0);
        for (int i = 0; i < n; i++) {
            v[edges[i][0]]++;
            v[edges[i][1]]++;
        }
        for (int i = 1; i <= n+1; i++) {
            if (v[i] == n) return i;
        }
        return -1;
    }
};