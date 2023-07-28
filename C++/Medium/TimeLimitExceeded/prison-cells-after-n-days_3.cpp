class Solution {
public:
    vector<int> prisonAfterNDays(vector<int>& cells, int n) {
        
        vector<int> temp(8, 0);
        int days = 0;
        while (days < n) {
            for (int i = 1; i < 7; ++i) {
                temp[i] = cells[i-1] == cells[i+1] ? 1 : 0;
            }
            cells = temp;
            ++days;
        }
        return cells;
    }
};