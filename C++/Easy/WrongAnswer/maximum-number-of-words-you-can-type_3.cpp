class Solution {
public:
    int canBeTypedWords(string text, string brokenLetters) {
        
        vector<int> broken(26, 0);
        for (auto c : brokenLetters) {
            broken[c - 'a'] = 1;
        }
        int res = 0;
        int i = 0;
        while (i < text.size()) {
            int j = i;
            while (j < text.size() && text[j] != ' ') {
                if (broken[text[j] - 'a']) {
                    break;
                }
                j++;
            }
            if (j == i) {
                res--;
            }
            if (j == text.size()) {
                break;
            }
            i = j + 1;
            res++;
        }
        return res;
    }
};