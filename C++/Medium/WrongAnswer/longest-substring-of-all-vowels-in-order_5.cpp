class Solution {
public:
    int longestBeautifulSubstring(string word) {
        
        int i = 0, j = 0, n = word.size(), ans = 0;
        while (j < n) {
            while (j < n && word[j] == word[j + 1]) {
                j++;
            }
            if (word[j] == 'a') {
                while (j < n && word[j] <= word[j + 1]) {
                    j++;
                }
                if (word[j] == 'u') {
                    ans = max(ans, j - i + 1);
                }
            }
            i = j;
            j++;
        }
        return ans;
    }
};