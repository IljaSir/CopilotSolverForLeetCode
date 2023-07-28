class Solution {
public:
    bool areSentencesSimilar(string sentence1, string sentence2) {
        
        int m = sentence1.size();
        int n = sentence2.size();
        if (m < n) {
            return areSentencesSimilar(sentence2, sentence1);
        }
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (sentence1[i] == sentence2[j]) {
                ++i;
                ++j;
            } else {
                break;
            }
        }
        if (i == m) {
            return true;
        }
        int k = m - 1;
        int l = n - 1;
        while (k >= 0 && l >= 0) {
            if (sentence1[k] == sentence2[l]) {
                --k;
                --l;
            } else {
                break;
            }
        }
        return k < i && l < j;
    }
};