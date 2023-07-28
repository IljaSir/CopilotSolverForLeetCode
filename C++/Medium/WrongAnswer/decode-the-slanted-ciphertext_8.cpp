class Solution {
public:
    string decodeCiphertext(string encodedText, int rows) {
        
        int n = encodedText.size();
        int cols = n / rows;
        int total = rows * cols;
        int rem = n - total;
        int c = 0;
        string res;
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if (i % 2 == 0) {
                    res += encodedText[c++];
                } else {
                    if (j == rows - 1) {
                        res += encodedText[c++];
                    } else {
                        res += ' ';
                    }
                }
            }
        }
        int i = 0;
        while (rem > 0) {
            res += encodedText[total + i];
            i += rows - 1;
            rem--;
        }
        return res;
    }
};