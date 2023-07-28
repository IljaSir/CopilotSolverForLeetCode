class Solution {
public:
    string truncateSentence(string s, int k) {
        
        int i = 0;
        for (int j = 0; j < s.size() && i < k; j++) {
            if (s[j] == ' ') {
                i++;
            }
        }
        
        return s.substr(0, i);
    }
};