class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        
        vector<vector<int>> result(n, vector<int>(n, 0));
        int i = 0;
        int j = 0;
        int count = 1;
        int direction = 0; // 0: right, 1: down, 2: left, 3: up
        while (count <= n * n) {
            result[i][j] = count;
            count++;
            if (direction == 0) {
                if (j + 1 < n && result[i][j + 1] == 0) {
                    j++;
                } else {
                    direction = 1;
                    i++;
                }
            } else if (direction == 1) {
                if (i + 1 < n && result[i + 1][j] == 0) {
                    i++;
                } else {
                    direction = 2;
                    j--;
                }
            } else if (direction == 2) {
                if (j - 1 >= 0 && result[i][j - 1] == 0) {
                    j--;
                } else {
                    direction = 3;
                    i--;
                }
            } else if (direction == 3) {
                if (i - 1 >= 0 && result[i - 1][j] == 0) {
                    i--;
                } else {
                    direction = 0;
                    j++;
                }
            }
        }
        return result;
    }
};