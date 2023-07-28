class Solution {
public:
    string decodeCiphertext(string encodedText, int rows) {
        
        int n = encodedText.size();
        int cols = n / rows;
        vector<vector<char>> m(rows, vector<char>(cols, ' '));
        int i = 0, j = 0;
        int k = 0;
        while (k < n) {
            while (i < rows && k < n) {
                m[i++][j] = encodedText[k++];
            }
            i -= 2;
            j++;
            while (i >= 0 && k < n) {
                m[i--][j++] = encodedText[k++];
            }
            i += 2;
        }
        string ans;
        for (i = 0; i < rows; i++) {
            for (j = 0; j < cols; j++) {
                if (m[i][j] != ' ')
                    ans += m[i][j];
            }
        }
        return ans;
    }
};