class Solution {
public:
    bool areOccurrencesEqual(string s) {
        
        int count[26] = {0};
        for (char c : s) {
            count[c - 'a']++;
        }
        int c = 0;
        for (int i = 0; i < 26; ++i) {
            if (count[i] > 0) {
                if (c == 0) {
                    c = count[i];
                } else if (c != count[i]) {
                    return false;
                }
            }
        }
        return true;
    }
};