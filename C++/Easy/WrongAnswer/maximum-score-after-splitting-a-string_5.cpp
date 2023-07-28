class Solution {
public:
    int maxScore(string s) {
        
        int n = s.size();
        int score = 0;
        int left = 0, right = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '0') {
                left++;
            }
        }
        for (int i = 0; i < n - 1; i++) {
            if (s[i] == '0') {
                left--;
            } else {
                right++;
            }
            score = max(score, left + right);
        }
        return score;
    }
};