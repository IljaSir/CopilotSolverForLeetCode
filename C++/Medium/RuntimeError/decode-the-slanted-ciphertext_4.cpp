class Solution {
public:
    string decodeCiphertext(string encodedText, int rows) {
        
        int c = encodedText.size() / rows;
        vector<vector<char>> matrix(rows, vector<char>(c));
        int i = 0, j = 0;
        for (char ch : encodedText) {
            if (ch == ' ') continue;
            matrix[i][j] = ch;
            if (i == 0 || i == rows - 1) {
                j++;
            }
            if (i == 0) {
                i++;
            } else if (i == rows - 1) {
                i--;
            } else {
                i++;
                j++;
            }
        }
        string originalText;
        i = 0, j = 0;
        for (int k = 0; k < encodedText.size(); k++) {
            if (matrix[i][j] != ' ') {
                originalText.push_back(matrix[i][j]);
            }
            if (i == 0 || i == rows - 1) {
                j++;
            }
            if (i == 0) {
                i++;
            } else if (i == rows - 1) {
                i--;
            } else {
                i++;
                j++;
            }
        }
        return originalText;
    }
};