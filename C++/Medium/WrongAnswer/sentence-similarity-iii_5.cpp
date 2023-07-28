class Solution {
public:
    bool areSentencesSimilar(string sentence1, string sentence2) {
        
        if (sentence1.length() < sentence2.length()) {
            swap(sentence1, sentence2);
        }
        if (sentence1.length() == sentence2.length()) {
            return sentence1 == sentence2;
        }
        int i = 0, j = 0;
        while (i < sentence1.length() && j < sentence2.length()) {
            if (sentence1[i] == sentence2[j]) {
                i++;
                j++;
            } else {
                break;
            }
        }
        if (j == sentence2.length()) {
            return true;
        }
        i = sentence1.length() - 1;
        j = sentence2.length() - 1;
        while (i >= 0 && j >= 0) {
            if (sentence1[i] == sentence2[j]) {
                i--;
                j--;
            } else {
                break;
            }
        }
        return j == -1;
    }
};