class Solution {
public:
    string decodeCiphertext(string encodedText, int rows) {
        
        int cols = encodedText.size() / rows;
        string result;
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                int index = j * cols + i;
                if (j % 2 == 0) {
                    if (i % 2 == 0) {
                        result += encodedText[index];
                    } else {
                        int index = j * cols + cols - i;
                        result += encodedText[index];
                    }
                } else {
                    if (i % 2 == 0) {
                        int index = j * cols + cols - i;
                        result += encodedText[index];
                    } else {
                        result += encodedText[index];
                    }
                }
            }
        }
        return result;
    }
};