class Solution {
public:
    int scoreOfParentheses(string s) {
        
        int score = 0;
        int level = 0;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '(') {
                level++;
            } else {
                level--;
                if (s[i-1] == '(') {
                    score += 1 << level;
                }
            }
        }
        return score;
    }
};