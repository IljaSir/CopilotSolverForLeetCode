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
            if (i == s.size() && j == word.size( s[i] == s[i + cnt1]) {
                cnt1++;
            }
            while (j < word.size() && word[j] == word[j + cnt2]) {
                cnt2++;
            }
            if (cnt1 < cnt2 || (cnt1 < 3 && cnt1 != cnt2)) {
                return false;
            }
            i += cnt1;
            j += cnt2;
        }
        return i == s.size() && j == word.size();
    }
};