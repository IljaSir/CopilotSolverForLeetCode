class Solution {
public:
    int expressiveWords(string s, vector<string>& words) {
        
        int res = 0;
        for (string word : words) {
            if (isStretchy(s, word)) {
                res++;
            }
        }
        return res;
    }
    
    bool isStretchy(strings, string word) {
        int i = 0,  0;
        while (i < s.size() && j < word.size()) {
            if (s[i] ![j]) {
                return false;
            }
            int count1 = 0, count2 = 0;
            while (i < s.size() && s[i] == s[i + 1]) {
                i++;
                count1++;
            }
            while (j < word.size() && word[j] == word[j + 1]) {
                j++;
                count2++;
            }
            if (count1 < count2 || (count1 != count2 && count1 < 2)) {
                return false;
            }
            i++;
            j++;
        }
        return i == s.size() && j == word.size();
    }
};