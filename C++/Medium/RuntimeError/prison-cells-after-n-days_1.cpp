class Solution {
public:
    vector<int> prisonAfterNDays(vector<int>& cells, int n) {
        
        vector<int> res(cells.size(), 0);
        for (int i = 1; i < cells.size() - 1; i++) {
            res[i] = (cells[i - 1] == cells[i + 1]) ? 1 : 0;
        }
        if (n == 1) return res;
        return prisonAfterNDays(res, n - 1);
    }
};