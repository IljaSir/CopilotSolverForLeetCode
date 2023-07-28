class Solution {
public:
    bool isItPossible(string word1, string word2) {
        
        int n = word1.size(), m = word2.size();
        int count1[26] = {0}, count2[26] = {0};
        for (int i = 0; i < n; i++) {
            count1[word1[i] - 'a']++;
        }
        for (int i = 0; i < m; i++) {
            count2[word2[i] - 'a']++;
        }
        int diff = 0;
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                diff++;
            }
        }
        return diff <= 2;
    }
    bool buddyStrings(string word1, string word2) {
        int n = word1.size(), m = word2.size();
        if (n != m) return false;
        int count1[26] = {0}, count2[26] = {0};
        for (int i = 0; i < n; i++) {
            count1[word1[i] - 'a']++;
        }
        for (int i = 0; i < m; i++) {
            count2[word2[i] - 'a']++;
        }
        int diff = 0;
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                diff++;
            }
        }
        if (diff == 0) {
            for (int i = 0; i < 26; i++) {
                if (count1[i] > 1) {
                    return true;
                }
            }
            return false;
        }
        if (diff != 2) return false;
        int ind1 = -1, ind2 = -1;
        for (int i = 0; i < n; i++) {
            if (word1[i] != word2[i]) {
                if (ind1 == -1) {
                    ind1 = i;
                } else {
                    ind2 = i;
                }
            }
        }
        if (ind1 == -1 || ind2 == -1) return false;
        swap(word1[ind1], word1[ind2]);
        return word1 == word2;
    }
};