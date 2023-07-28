class Solution {
public:
    bool checkAlmostEquivalent(string word1, string word2) {
        
        int n = word1.length();
        if (n != word2.length()) {
            return false;
        }
        int freq1[26] = {0};
        int freq2[26] = {0};
        for (int i = 0; i < n; i++) {
            freq1[word1[i] - 'a']++;
            freq2[word2[i] - 'a']++;
        }
        int diff = 0;
        for (int i = 0; i < 26; i++) {
            diff += abs(freq1[i] - freq2[i]);
        }
        return diff <= 6;
    }
};