class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        
        vector<vector<int>> res(n, vector<int>(n, 0));
        int i = 0, j = 0, cnt = 1;
        while (cnt <= n * n) {
            while (j < n && res[i][j] == 0) res[i][j++] = cnt++;
            i++, j--;
            while (i < n && res[i][j] == 0) res[i++][j] = cnt++;
            i--, j--;
            while (j >= 0 && res[i][j] == 0) res[i][j--] = cnt++;
            i--, j++;
            while (i >= 0 && res[i][j] == 0) res[i--][j] = cnt++;
            i++, j++;
        }
        return res;
    }
};