class Solution {
public:
    vector<string> printVertically(string s) {
        
        vector<string> result;
        int i = 0;
        int j = 0;
        int maxLen = 0;
        while (i < s.length()) {
            j = i;
            while (j < s.length() && s[j] != ' ') {
                j++;
            }
            maxLen = max(maxLen, j - i);
            i = j + 1;
        }
        i = 0;
        while (i < maxLen) {
            string word;
            j = 0;
            while (j < s.length()) {
                while (j < s.length() && s[j] == ' ') {
                    j++;
                }
                if (j < s.length()) {
                    if (i < j - i) {
                        word.push_back(' ');
                    } else {
                        word.push_back(s[j]);
                    }
                    j++;
                }
            }
            while (word.length() > 0 && word.back() == ' ') {
                word.pop_back();
            }
            result.push_back(word);
            i++;
        }
        return result;
    }
};