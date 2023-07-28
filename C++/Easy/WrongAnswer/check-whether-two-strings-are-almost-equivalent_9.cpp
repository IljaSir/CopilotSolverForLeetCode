class Solution {
public:
    bool checkAlmostEquivalent(string word1, string word2) {
        
        int word1Count[26] = {0};
        int word2Count[26] = {0};
        for (char c : word1) {
            ++word1Count[c - 'a'];
        }
        for (char c : word2) {
            ++word2Count[c - 'a'];
        }
        int diff = 0;
        for (int i = 0; i < 26; ++i) {
            diff += abs(word1Count[i] - word2Count[i]);
        }
        return diff <= 3;
    }
};