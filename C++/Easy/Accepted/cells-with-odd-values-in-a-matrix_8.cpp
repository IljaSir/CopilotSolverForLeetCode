class Solution {
public:
    int oddCells(int m, int n, vector<vector<int>>& indices) {
        
        int ans = 0;
        vector<int> row(m, 0), col(n, 0);
        for (auto& idx : indices) {
            row[idx[0]] ^= 1;
            col[idx[1]] ^= 1;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] ^ col[j]) {
                    ans++;
                }
            }
        }
        return ans;
    }
};