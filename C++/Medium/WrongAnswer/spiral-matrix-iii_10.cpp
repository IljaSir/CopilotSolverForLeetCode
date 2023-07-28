class Solution {
public:
    vector<vector<int>> spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        
        vector<vector<int>> result;
        int r = rStart, c = cStart;
        int n = 0;
        while (result.size() < rows * cols) {
            while (r >= 0 && r < rows && c >= 0 && c < cols) {
                result.push_back({r, c});
                c++;
            }
            r++;
            c--;
            while (r >= 0 && r < rows && c >= 0 && c < cols) {
                result.push_back({r, c});
                r++;
            }
            r--;
            c--;
            while (r >= 0 && r < rows && c >= 0 && c < cols) {
                result.push_back({r, c});
                c--;
            }
            r--;
            c++;
            while (r >= 0 && r < rows && c >= 0 && c < cols) {
                result.push_back({r, c});
                r--;
            }
            r++;
            c++;
            n++;
        }
        return result;
    }
};