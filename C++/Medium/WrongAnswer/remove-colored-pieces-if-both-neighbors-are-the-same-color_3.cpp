class Solution {
public:
    bool winnerOfGame(string colors) {
        
        int n = colors.size();
        int count = 0;
        for (int i = 1; i < n - 1; ++i) {
            if (colors[i] == colors[i - 1] && colors[i] == colors[i + 1]) {
                ++count;
            }
        }
        return count > (n - 2) / 2;
    }
};