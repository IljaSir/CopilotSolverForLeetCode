class Solution {
public:
    int equalPairs(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int r[n], c[n];
        for (int i = 0; i < n; i++) {
            r[i] = 0;
            c[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                r[i] = r[i] * 10 + grid[i][j];
                c[j] = c[j] * 10 + grid[i][j];
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (r[i] == r[j]) count++;
                if (c[i] == c[j]) count++;
            }
        }
        return count;
    }
};