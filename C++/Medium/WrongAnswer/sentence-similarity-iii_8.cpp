class Solution {
public:
    bool areSentencesSimilar(string sentence1, string sentence2) {
        
        if (sentence1 == sentence2) return true;
        int m = sentence1.size();
        int n = sentence2.size();
        if (m < n) {
            string t = sentence1;
            sentence1 = sentence2;
            sentence2 = t;
            int tt = m;
            m = n;
            n = tt;
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
        if (j == n) {
            while (i < m) {
                if (sentence1[i] == ' ') {
                    ++i;
                } else {
                    break;
                }
            }
            if (i == m) {
                return true;
            }
        }
        i = m - 1;
        j = n - 1;
        while (i >= 0 && j >= 0) {
            if (sentence1[i] == sentence2[j]) {
                --i;
                --j;
            } else {
                break;
            }
        }
        if (j == -1) {
            while (i >= 0) {
                if (sentence1[i] == ' ') {
                    --i;
                } else {
                    break;
                }
            }
            if (i == -1) {
                return true;
            }
        }
        return false;
    }
};