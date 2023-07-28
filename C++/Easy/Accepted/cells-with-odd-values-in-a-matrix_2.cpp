class Solution {
public:
    int oddCells(int m, int n, vector<vector<int>>& indices) {
        
        vector<int> rows(m, 0);
        vector<int> cols(n, 0);
        int count = 0;
        for (int i = 0; i < indices.size(); i++) {
            rows[indices[i][0]]++;
            cols[indices[i][1]]++;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((rows[i] + cols[j]) % 2 == 1) {
                    count++;
                }
            }
        }
        return count;
    }
};