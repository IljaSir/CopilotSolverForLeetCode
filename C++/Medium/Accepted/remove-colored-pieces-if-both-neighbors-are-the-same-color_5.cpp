class Solution {
public:
    bool winnerOfGame(string colors) {
        
        int countA = 0, countB = 0;
        int n = colors.size();
        for (int i = 1; i < n - 1; ++i) {
            if (colors[i] == 'A' && colors[i - 1] == 'A' && colors[i + 1] == 'A') {
                ++countA;
            }
            if (colors[i] == 'B' && colors[i - 1] == 'B' && colors[i + 1] == 'B') {
                ++countB;
            }
        }
        return countA > countB;
    }
};