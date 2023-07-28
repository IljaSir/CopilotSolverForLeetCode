class Solution {
public:
    bool areSentencesSimilar(string sentence1, string sentence2) {
        
        if (sentence1 == sentence2) return true;
        int i = 0, j = 0;
        while (i < sentence1.size() && j < sentence2.size()) {
            if (sentence1[i] == sentence2[j]) {
                ++i; ++j;
            } else {
                break;
            }
        }
        int k = sentence1.size() - 1, l = sentence2.size() - 1;
        while (k >= i && l >= j) {
            if (sentence1[k] == sentence2[l]) {
                --k; --l;
            } else {
                break;
            }
        }
        return i > k || j > l;
    }
};