class Solution {
public:
    bool closeStrings(string word1, string word2) {
        
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 != len2) return false;
        int charMap1[26] = {0};
        int charMap2[26] = {0};
        for (int i = 0; i < len1; i++) {
            charMap1[word1[i] - 'a']++;
            charMap2[word2[i] - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (charMap1[i] == 0 && charMap2[i] != 0) return false;
            if (charMap1[i] != 0 && charMap2[i] == 0) return false;
        }
        sort(charMap1, charMap1 + 26);
        sort(charMap2, charMap2 + 26);
        for (int i = 0; i < 26; i++) {
            if (charMap1[i] != charMap2[i]) return false;
        }
        return true;
    }
};