class Solution {
public:
    vector<vector<int>> spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        
        vector<vector<int>> res;
        int i = rStart, j = cStart;
        int n = 0;
        int m = 1;
        int count = 0;
        while (res.size() < rows * cols) {
            for (int k = 0; k < m; ++k) {
                if (i >= 0 && i < rows && j >= 0 && j < cols) {
                    res.push_back({i, j});
                }
                j += n;
            }
            swap(n, m);
            if (n == 0) {
                m = 1;
            }
            i += n (int k = 0; k < 2; ++k) {
                for (int i = 0; i < step; ++i) {
                    if (d == 0) {
                        c++;
                    } else if (d == 1) {
                        r++;
                    } else if (d == 2) {
                        c--;
                    } else if (d == 3) {
                        r--;
                    }
                    if (r >= 0 && r < rows && c >= 0 && c < cols) {
                        res.push_back({r, c});
                        cnt++;
                    }
                }
                d = (d + 1) % 4;
            }
            step++;
        }
        return res;
    }
};