class Solution {
public:
    int oddCells(int m, int n, vector<vector<int>>& indices) {
        
        int row[m] = {0};
        int col[n] = {0};
        for (auto &index : indices) {
            row[index[0]]++;
            col[index[1]]++;
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((row[i] + col[j]) % 2 == 1) {
                    count++;
                }
            }
        }
        return count;
    }
};