class Solution {
public:
    int oddCells(int m, int n, vector<vector<int>>& indices) {
        
        vector<int> row(m, 0), col(n, 0);
        for (auto& i: indices) {
            row[i[0]]++;
            col[i[1]]++;
        }
        int res = 0;
        for (auto& i: row) {
            for (auto& j: col) {
                if ((i + j) % 2 == 1) res++;
            }
        }
        return res;
    }
};