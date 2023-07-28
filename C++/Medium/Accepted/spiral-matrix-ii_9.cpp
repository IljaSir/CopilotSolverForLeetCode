class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        
        vector<vector<int>> res(n, vector<int>(n));
        const int N = n * n;
        int i = 0, j = 0, k = 1, d = 0;
        while (k <= N) {
            res[i][j] = k++;
            switch (d) {
                case 0:
                    if (j + 1 < n && res[i][j + 1] == 0) {
                        j++;
                    } else {
                        d = (d + 1) % 4;
                        i++;
                    }
                    break;
                case 1:
                    if (i + 1 < n && res[i + 1][j] == 0) {
                        i++;
                    } else {
                        d = (d + 1) % 4;
                        j--;
                    }
                    break;
                case 2:
                    if (j - 1 >= 0 && res[i][j - 1] == 0) {
                        j--;
                    } else {
                        d = (d + 1) % 4;
                        i--;
                    }
                    break;
                case 3:
                    if (i - 1 >= 0 && res[i - 1][j] == 0) {
                        i--;
                    } else {
                        d = (d + 1) % 4;
                        j++;
                    }
                    break;
            }
        }
        return res;
    }
};