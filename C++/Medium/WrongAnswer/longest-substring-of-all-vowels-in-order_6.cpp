class Solution {
public:
    int longestBeautifulSubstring(string word) {
        
        int i = 0, j = 0, n = word.size(), ans = 0;
        while (i < n) {
            char c = word[i];
            if (c != 'a') return ans;
            while (j < n && word[j] == c) ++j;
            if (j == n) return ans;
            c = word[j];
            while (j < n && word[j] == c) ++j;
            if (j == n) return ans;
            c = word[j];
            while (j < n && word[j] == c) ++j;
            if (j == n) return ans;
            c = word[j];
            while (j < n && word[j] == c) ++j;
            if (j == n) return ans;
            c = word[j];
            while (j < n && word[j] == c) ++j;
            ans = max(ans, j - i);
            i = j;
        }
        return ans;
    }
};