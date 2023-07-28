class Solution {
public:
    string decodeCiphertext(string encodedText, int rows) {
        
        string result;
        int n = encodedText.size();
        if (n == 0) return result;
        int cols = n / rows;
        int i = 0, j = 0;
        int k = 0;
        vector<vector<char>> matrix(rows, vector<char>(cols, ' '));
        while (k < n) {
            while (i < rows) {
                matrix[i][j] = encodedText[k];
                k++;
                i++;
            }
            i -= 2;
            j++;
            while (i > 0) {
                matrix[i][j] = encodedText[k];
                k++;
                i--;
                j++;
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] != ' ') {
                    result += matrix[i][j];
                }
            }
        }
        return result;
    }
};