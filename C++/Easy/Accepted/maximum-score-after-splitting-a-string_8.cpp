class Solution {
public:
    int maxScore(string s) {
        
        int num0 = 0;
        for (auto c : s) {
            if (c == '0') {
                num0 += 1;
            }
        }
        int num1 = s.size() - num0;
        int maxScore = 0;
        int num0Left = 0;
        int num1Right = num1;
        for (int i = 0; i < s.size() - 1; ++i) {
            if (s[i] == '0') {
                num0Left += 1;
            } else {
                num1Right -= 1;
            }
            maxScore = max(maxScore, num0Left + num1Right);
        }
        return maxScore;
    }
};