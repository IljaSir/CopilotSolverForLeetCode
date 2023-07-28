class Solution {
public:
    vector<int> prisonAfterNDays(vector<int>& cells, int n) {
        
        vector<int> temp(8);
        vector<int> res;
        int i = 1;
        while (i <= n) {
            for (int j = 1; j < 7; j++) {
                if (cells[j-1] == cells[j+1]) {
                    temp[j] = 1;
                } else {
                    temp[j] = 0;
                }
            }
            if (res.size() > 0 && res == temp) {
                break;
            } else {
                res = temp;
                i++;
            }
        }
        return res;
    }
};