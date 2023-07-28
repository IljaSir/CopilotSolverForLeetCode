class Solution {
public:
    int longestBeautifulSubstring(string word) {
        
        int n = word.length(), i = 0, j = 0, res = 0;
        while (i < n) {
            while (j < n && word[j] >= word[i]) {
                i = j;
                j++;
            }
            while (j < n && word[j] < word[i]) {
                i = j;
                j++;
            }
            if (word[i] != 'a') {
                i = j;
                j++;
            } else {
                while (j < n && word[j] == word[i]) {
                    j++;
                }
                if (word[j - 1] == 'u') {
                    res = max(res, j - i);
                }
                i = j;
                j++;
            }
        }
        return res;
    }
};