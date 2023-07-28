class Solution {
public:
    bool winnerOfGame(string colors) {
        
        int n = colors.size();
        int a = 0, b = 0;
        for (int i = 0; i < n; ++i) {
            if (colors[i] == 'A') {
                int j = i;
                while (j < n && colors[j] == 'A') ++j;
                if (j - i > 2) a += j - i - 2;
                i = j - 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (colors[i] == 'B') {
                int j = i;
                while (j < n && colors[j] == 'B') ++j;
                if (j - i > 2) b += j - i - 2;
                i = j - 1;
            }
        }
        return a > b;
    }
};