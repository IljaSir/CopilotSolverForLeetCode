class Solution {
public:
    string truncateSentence(string s, int k) {
        
        int i = 0;
        while (i < s.size() && k > 0) {
            if (s[i] == ' ') {
                k--;
            }
            i++;
        }
        if (i < s.size()) {
            s.erase(s.begin() + i, s.end());
        }
        return s;
    }
};