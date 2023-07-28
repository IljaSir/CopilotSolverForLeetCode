class Solution {
public:
    bool isItPossible(string word1, string word2) {
        
        if (word1.length() != word2.length()) {
            return false;
        }
        if (word1 == word2) {
            return true;
        }
        vector<int> a(26, 0);
        vector<int> b(26, 0);
        for (int i = 0; i < word1.length(); i++) {
            a[word1[i] - 97]++;
            b[word2[i] - 97]++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (a[i] > 0 && b[i] > 0) {
                count++;
            }
        }
        if (count == 0) {
            return false;
        }
        return true;
    }
};