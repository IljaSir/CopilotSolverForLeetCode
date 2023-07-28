class Solution {
public:
    int maximumGain(string s, int x, int y) {
        
        int score = 0;
        string str;
        for (int i = 0; i < s.length(); i++) {
            if (s[i] == 'a' || s[i] == 'b') {
                str.push_back(s[i]);
            }
            if (s[i] == 'a' && str.length() > 0 && str.back() == 'b') {
                str.pop_back();
                score += x;
            }
            if (s[i] == 'b' && str.length() > 0 && str.back() == 'a') {
                str.pop_back();
                score += y;
            }
        }
        return score;
    }
};