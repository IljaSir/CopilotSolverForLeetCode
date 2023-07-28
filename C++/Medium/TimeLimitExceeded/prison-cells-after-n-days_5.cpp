class Solution {
public:
    vector<int> prisonAfterNDays(vector<int>& cells, int n) {
        
        vector<int> res(cells);
        for (int i = 0; i < n; ++i) {
            vector<int> temp(res);
            for (int j = 0; j < 8; ++j) {
                if (j == 0 || j == 7) {
                    temp[j] = 0;
                } else {
                    temp[j] = res[j-1] == res[j+1] ? 1 : 0;
                }
            }
            res = temp;
        }
        return res;
    }
};