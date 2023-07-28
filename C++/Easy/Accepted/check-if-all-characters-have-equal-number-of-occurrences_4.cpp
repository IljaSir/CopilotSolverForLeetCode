class Solution {
public:
    bool areOccurrencesEqual(string s) {
        
        int cnt[26] = {0};
        for (char c : s) {
            cnt[c - 'a']++;
        }
        int prev = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] != 0) {
                if (prev != 0 && prev != cnt[i]) {
                    return false;
                }
                prev = cnt[i];
            }
        }
        return true;
    }
};