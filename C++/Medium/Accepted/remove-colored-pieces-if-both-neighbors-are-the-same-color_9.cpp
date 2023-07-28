class Solution {
public:
    bool winnerOfGame(string colors) {
        
        int len = colors.size();
        int a = 0, b = 0;
        int i = 0, j = 0;
        while (i < len) {
            while (j < len && colors[j] == colors[i]) {
                ++j;
            }
            if (colors[i] == 'A' && j - i > 2) {
                a += j - i - 2;
            }
            if (colors[i] == 'B' && j - i > 2) {
                b += j - i - 2;
            }
            i = j;
        }
        return a > b;
    }
};