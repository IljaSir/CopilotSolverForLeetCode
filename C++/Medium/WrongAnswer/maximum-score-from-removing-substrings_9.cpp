class Solution {
public:
    int maximumGain(string s, int x, int y) {
        
        int maxScore = 0;
        if (x < y) {
            maxScore += remove(s, "ba", x);
            maxScore += remove(s, "ab", y);
        } else {
            maxScore += remove(s, "ab", y);
            maxScore += remove(s, "ba", x);
        }
        return maxScore;
    }
    
    int remove(string& s, string pattern, int score) {
        int maxScore = 0;
        int pos = s.find(pattern);
        while (pos != string::npos) {
            maxScore += score;
            s.erase(pos, pattern.size());
            pos = s.find(pattern);
        }
        return maxScore;
    }
};