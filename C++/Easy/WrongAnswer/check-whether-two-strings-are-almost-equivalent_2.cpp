class Solution {
public:
    bool checkAlmostEquivalent(string word1, string word2) {
        
        if (word1.length() != word2.length()) return false;
        int freq1[26] = {0};
        int freq2[26] = {0};
        for (int i = 0; i < word1.length(); i++) {
            freq1[word1[i] - 'a']++;
            freq2[word2[i] - 'a']++;
        }
        int diff = 0;
        for (int i = 0; i < 26; i++) {
            diff += abs(freq1[i] - freq2[i]);
            if (diff > 3) return false;
        }
        return true;
    }
};