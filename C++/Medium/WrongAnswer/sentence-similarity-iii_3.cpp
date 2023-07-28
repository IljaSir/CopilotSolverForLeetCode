class Solution {
public:
    bool areSentencesSimilar(string sentence1, string sentence2) {
        
        if (sentence1.size() < sentence2.size()) {
            swap(sentence1, sentence2);
        }
        int i = 0;
        int j = 0;
        while (i < sentence1.size() && j < sentence2.size()) {
            if (sentence1[i] == sentence2[j]) {
                i++;
                j++;
            } else {
                int k = i;
                int l = j;
                while (k < sentence1.size() && sentence1[k] != ' ') {
                    k++;
                }
                while (l < sentence2.size() && sentence2[l] != ' ') {
                    l++;
                }
                if (k - i != l - j) {
                    return false;
                }
                i = k;
                j = l;
            }
        }
        while (i < sentence1.size() && sentence1[i] == ' ') {
            i++;
        }
        while (j < sentence2.size() && sentence2[j] == ' ') {
            j++;
        }
        return i == sentence1.size() && j == sentence2.size();
    }
};