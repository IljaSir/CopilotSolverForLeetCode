class Solution {
public:
    int oddCells(int m, int n, vector<vector<int>>& indices) {
        
        int res = 0;
        vector<int> rows(m, 0);
        vector<int> cols(n, 0);
        for (auto &idx : indices) {
            rows[idx[0]]++;
            cols[idx[1]]++;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((rows[i] + cols[j]) % 2 != 0) {
                    res++;
                }
            }
        }
        return res;
    }
};