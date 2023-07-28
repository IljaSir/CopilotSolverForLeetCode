class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        
        vector<vector<int>> ans(n, vector<int>(n));
        int i = 0, j = 0;
        int cnt = 1;
        int state = 0;
        while (cnt <= n * n) {
            ans[i][j] = cnt;
            if (state == 0) {
                if (j + 1 < n && ans[i][j + 1] == 0) {
                    j++;
                } else {
                    state = 1;
                    i++;
                }
            } else if (state == 1) {
                if (i + 1 < n && ans[i + 1][j] == 0) {
                    i++;
                } else {
                    state = 2;
                    j--;
                }
            } else if (state == 2) {
                if (j - 1 >= 0 && ans[i][j - 1] == 0) {
                    j--;
                } else {
                    state = 3;
                    i--;
                }
            } else if (state == 3) {
                if (i - 1 >= 0 && ans[i - 1][j] == 0) {
                    i--;
                } else {
                    state = 0;
                    j++;
                }
            }
            cnt++;
        }
        return ans;
    }
};