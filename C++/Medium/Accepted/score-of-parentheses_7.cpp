class Solution {
public:
    int scoreOfParentheses(string s) {
        
        int n = s.size(), score = 0;
        for (int i = 0; i < n; ++i) {
            if (s[i] == '(') {
                if (s[i + 1] == ')') {
                    score += 1;
                    ++i;
                } else {
                    int j = i;
                    int count = 0;
                    while (j < n) {
                        if (s[j] == '(') {
                            ++count;
                        } else {
                            --count;
                        }
                        if (count == 0) {
                            score += 2 * scoreOfParentheses(s.substr(i + 1, j - i - 1));
                            i = j;
                            break;
                        }
                        ++j;
                    }
                }
            }
        }
        return score;
    }
};