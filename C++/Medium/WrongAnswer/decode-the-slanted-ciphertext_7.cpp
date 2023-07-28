class Solution {
public:
    string decodeCiphertext(string encodedText, int rows) {
        
        int n = encodedText.size();
        if (rows == 1) return encodedText;
        int cols = (n+rows-2)/(rows-1);
        int m = cols * rows;
        vector<vector<char>> a(rows, vector<char>(cols, ' '));
        int i = 0, j = 0;
        for (int k = 0; k < n; ++k) {
            a[i][j] = encodedText[k];
            if ((i+j)%2 == 0) {
                if (i < rows-1) ++i;
                else ++j;
            } else {
                if (i > 0) --i;
                else ++j;
            }
        }
        string ans;
        for (int k = 0; k < m; ++k) {
            i = k / cols;
            j = k % cols;
            if (a[i][j] != ' ') ans.push_back(a[i][j]);
        }
        return ans;
    }
};