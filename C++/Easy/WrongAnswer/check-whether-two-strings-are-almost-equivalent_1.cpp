class Solution {
public:
    bool checkAlmostEquivalent(string word1, string word2) {
        
        int count1[26] = {0};
        int count2[26] = {0};
        for (char c: word1) {
            count1[c - 'a']++;
        }
        for (char c: word2) {
            count2[c - 'a']++;
        }
        int diff = 0;
        for (int i = 0; i < 26; i++) {
            diff += abs(count1[i] - count2[i]);
        }
        return diff <= 3;
    }
};