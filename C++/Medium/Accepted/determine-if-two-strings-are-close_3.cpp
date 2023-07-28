class Solution {
public:
    bool closeStrings(string word1, string word2) {
        
        if (word1.size() != word2.size()) return false;
        int m1[26] = {0};
        int m2[26] = {0};
        for (char c : word1) m1[c - 'a']++;
        for (char c : word2) m2[c - 'a']++;
        for (int i = 0; i < 26; i++) {
            if (m1[i] == 0 && m2[i] != 0) return false;
            if (m1[i] != 0 && m2[i] == 0) return false;
        }
        sort(m1, m1 + 26);
        sort(m2, m2 + 26);
        for (int i = 0; i < 26; i++) {
            if (m1[i] != m2[i]) return false;
        }
        return true;
    }
};