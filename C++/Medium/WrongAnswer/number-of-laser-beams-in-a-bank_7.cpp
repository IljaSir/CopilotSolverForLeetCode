class Solution {
public:
    int numberOfBeams(vector<string>& bank) {
        
        int m = bank.size();
        int n = bank[0].size();
        int cnt = 0;
        for (int i = 1; i < m; ++i) {
            bool flag = false;
            for (int j = 0; j < n; ++j) {
                if (bank[i][j] == '1') {
                    if (flag) {
                        ++cnt;
                    }
                    flag = true;
                }
            }
        }
        return cnt;
    }
};