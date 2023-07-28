class Solution {
public:
    bool areOccurrencesEqual(string s) {
        
        int count[26] = {0};
        for (char c : s) {
            count[c - 'a']++;
        }
        int first = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                first = count[i];
                break;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0 && count[i] != first) {
                return false;
            }
        }
        return true;
    }
};