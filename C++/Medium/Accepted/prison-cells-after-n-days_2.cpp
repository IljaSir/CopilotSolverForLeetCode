class Solution {
public:
    vector<int> prisonAfterNDays(vector<int>& cells, int n) {
        
        vector<int> res(cells.size(), 0);
        int m = n % 14;
        if (m == 0) m = 14;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < cells.size() - 1; j++) {
                if (cells[j - 1] == cells[j + 1]) res[j] = 1;
                else res[j] = 0;
            }
            cells = res;
        }
        return res;
    }
};