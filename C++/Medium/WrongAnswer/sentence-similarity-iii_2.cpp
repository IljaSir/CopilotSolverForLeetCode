class Solution {
public:
    bool areSentencesSimilar(string sentence1, string sentence2) {
        
        int i = 0, j = 0;
        int m = sentence1.size(), n = sentence2.size();
        while (i < m && j < n) {
            if (sentence1[i] == sentence2[j]) {
                ++i;
                ++j;
            } else {
                break;
            }
        }
        if (i == m && j == n) {
            return true;
        }
        int k = m - 1, l = n - 1;
        while (k >= 0 && l >= 0) {
            if (sentence1[k] == sentence2[l]) {
                --k;
                --l;
            } else {
                break;
            }
        }
        if (i == k + 1 || j == l + 1) {
            return true;
        }
        return false;
    }
};