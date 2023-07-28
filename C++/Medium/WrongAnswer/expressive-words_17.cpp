class Solution {
public:
    int expressiveWords(string s, vector<string>& words) {
        
        int res = 0;
        for (string& word: words) {
            int i = 0, j = 0;
            while (j < word.size()) {
                if (i < s.size() && s[i] == word[j]) {
                    ++i;
                    ++j;
                } else if (i > 0 && s[i-1] == s[i] && i+1 < s.size() && s[i] == s[i+1]) {
                    ++i;
                } else {
                    break;
                }
            }
            if (i == s.size() && j == word.size()) {
                ++res;
            }
        }
        return res;
    }
};