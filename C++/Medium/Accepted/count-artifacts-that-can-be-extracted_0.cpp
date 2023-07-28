class Solution {
public:
    int digArtifacts(int n, vector<vector<int>>& artifacts, vector<vector<int>>& dig) {
        
        vector<vector<int>> grid(n, vector<int>(n, 0));
        for (auto& a : artifacts) {
            for (int i = a[0]; i <= a[2]; i++) {
                for (int j = a[1]; j <= a[3]; j++) {
                    grid[i][j] = 1;
                }
            }
        }
        for (auto& d : dig) {
            grid[d[0]][d[1]] = 2;
        }
        int res = 0;
        for (auto& a : artifacts) {
            int cnt = 0;
            for (int i = a[0]; i <= a[2]; i++) {
                for (int j = a[1]; j <= a[3]; j++) {
                    if (grid[i][j] == 2) {
                        cnt++;
                    }
                }
            }
            if (cnt == (a[2] - a[0] + 1) * (a[3] - a[1] + 1)) {
                res++;
            }
        }
        return res;
    }
};