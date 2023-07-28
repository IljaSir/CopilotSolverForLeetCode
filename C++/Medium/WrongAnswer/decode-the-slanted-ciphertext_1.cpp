class Solution {
public:
    string decodeCiphertext(string encodedText, int rows) {
        
        int n = encodedText.size();
        int cols = n / rows;
        string res = "";
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                int index = j * cols + i;
                if (index < n) {
                    res += encodedText[index];
                }
            }
        }
        return res;
    }
};