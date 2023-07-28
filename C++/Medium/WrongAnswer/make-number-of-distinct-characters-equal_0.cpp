class Solution {
public:
    bool isItPossible(string word1, string word2) {
        
        int n1 = word1.length();
        int n2 = word2.length();
        if (n1 != n2) {
            return false;
        }
        int count1[26] = {0};
        int count2[26] = {0};
        for (int i = 0; i < n1; i++) {
            count1[word1[i] - 'a']++;
            count2[word2[i] - 'a']++;
        }
        int diff = 0;
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                diff++;
            }
        }
        return diff == 2;
    }
};