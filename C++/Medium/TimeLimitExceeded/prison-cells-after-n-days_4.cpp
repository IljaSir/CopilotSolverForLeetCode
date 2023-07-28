class Solution {
public:
    vector<int> prisonAfterNDays(vector<int>& cells, int n) {
        
        vector<int> res(8, 0);
        int day = 0;
        while (day < n) {
            for (int i = 1; i < 7; i++) {
                if (cells[i - 1] == cells[i + 1]) {
                    res[i] = 1;
                } else {
                    res[i] = 0;
                }
            }
            cells = res;
            day++;
        }
        return res;
    }
};