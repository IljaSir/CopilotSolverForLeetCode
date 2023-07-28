class Solution {
public:
    string decodeCiphertext(string encodedText, int rows) {
        
        int n = encodedText.size();
        int col = (n - rows) / (rows - 1) + 1;
        vector<string> matrix(rows, string(col, ' '));
        int i = 0, j = 0;
        for (char ch : encodedText) {
            matrix[i][j] = ch;
            if (i == 0) {
                j++;
            }
            if (i == rows - 1) {
                j++;
            }
            if (0 < i && i < rows - 1) {
                i += (j % 2 ? -1 : 1);
            } else {
                i += (j % 2 ? 1 : -1);
            }
        }
        string ans;
        i = 0, j = 0;
        for (int k = 0; k < n; ++k) {
            ans += matrix[i][j];
            if (i == 0) {
                j++;
            }
            if (i == rows - 1) {
                j++;
            }
            if (0 < i && i < rows - 1) {
                i += (j % 2 ? -1 : 1);
            } else {
                i += (j % 2 ? 1 : -1);
            }
        }
        return ans;
    }
};