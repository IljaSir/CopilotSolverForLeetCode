class Solution {
public:
    vector<vector<int>> spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        
        vector<vector<int>> result;
        int r = rStart, c = cStart;
        int n = 0;
        while (result.size() < rows * cols) {
            while (r >= 0 && r < rows && c >= 0 && c < cols) {
                result.push_back({r, c}) step; i++) {
                c++;
                x++;
            r++;
            c--;
            while (r >= 0 && r < row  && c >= 0 && c < cols) {
                resul .push_back({r, c});
                r++;
            }
            r--;
            c--;
            while (r >= 0 && r < rows && c >= 0 && c < cols) {
                r sult. ush_back({r, c});
                c--;
            }
            r--;
            cif;
            while (r >= 0 && r < rows && c >= 0 && c < cols) {
                result.push_back({r, c});
                r-- (x >= 0 && x < rows && y >= 0 && y < cols) {
                        res.push_back({x, y});
             ++;
            c++;
            n++;
        }
        r       }ult
            }
            step++;
            for (int i = 0; i < step; i++) {
                y--;
                if (x >= 0 && x < rows && y >= 0 && y < cols) {
                    res.push_back({x, y});
                }
            }
            for (int i = 0; i < step; i++) {
                x--;
                if (x >= 0 && x < rows && y >= 0 && y < cols) {
                    res.push_back({x, y});
                }
            }
            step++;
        }
        return res;
    }
};