class Solution {
public:
    bool areSentencesSimilar(string sentence1, string sentence2) {
        
        if (sentence1.size() < sentence2.size()) {
            swap(sentence1, sentence2);
        }
        int i = 0, j = 0;
        while (i < sentence1.size() && j < sentence2.size()) {
            if (sentence1[i] == sentence2[j]) {
                i++;
                j++;
            } else {
                if (i > 0 && sentence1[i - 1] == ' ') {
                    return false;
                }
                while (i < sentence1.size() && sentence1[i] != ' ') {
                    i++;
                }
            }
        }
        while (i < sentence1.size() && sentence1[i] == ' ') {
            i++;
        }
        return i == sentence1.size();
    }
};