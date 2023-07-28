class Solution {
public:
    string shiftingLetters(string s, vector<vector<int>>& shifts) {
        
        for (int i = shifts.size() - 1; i >= 0; i--) {
            shifts[i][2] %= 26;
            if (i > 0) shifts[i - 1][2] += shifts[i][2];
        }
        for (int i = 0; i < shifts.size(); i++) {
            int start = shifts[i][0], end = shifts[i][1], dir = shifts[i][2];
            for (int j = start; j <= end; j++) {
                s[j] = (s[j] - 'a' + dir) % 26 + 'a';
            }
        }
        return s;
    }
};