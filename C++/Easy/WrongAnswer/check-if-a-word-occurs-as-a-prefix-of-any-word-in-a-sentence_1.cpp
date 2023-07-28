class Solution {
public:
    int isPrefixOfWord(string sentence, string searchWord) {
        
        int n = sentence.size();
        int m = searchWord.size();
        if (n < m) return -1;
        int i = 0;
        int j = 0;
        int ans = 0;
        while (i < n) {
            if (sentence[i] == ' ') {
                j = 0;
                ans++;
                i++;
                continue;
            }
            if (j < m && sentence[i] == searchWord[j]) {
                j++;
            } else {
                j = 0;
                ans++;
            }
            i++;
            if (j == m) return ans;
        }
        return -1;
    }
};