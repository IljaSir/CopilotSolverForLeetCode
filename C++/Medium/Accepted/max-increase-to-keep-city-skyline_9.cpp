class Solution {
public:
    int maxIncreaseKeepingSkyline(vector<vector<int>>& grid) {
        
        int n = grid.size();
        vector<int> v1(n, 0);
        vector<int> v2(n, 0);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                v1[i] = max(v1[i], grid[i][j]);
                v2[j] = max(v2[j], grid[i][j]);
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                ans += min(v1[i], v2[j]) - grid[i][j];
            }
        }
        return ans;
    }
};