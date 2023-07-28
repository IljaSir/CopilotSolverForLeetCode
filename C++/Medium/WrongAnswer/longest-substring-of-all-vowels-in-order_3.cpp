class Solution {
public:
    int longestBeautifulSubstring(string word) {
        
        int l = 0, r = 0, n = word.length();
        int res = 0;
        while (r < n) {
            while (r < n && word[r] == 'a') r++;
            while (r < n && word[r] == 'e') r++;
            while (r < n && word[r] == 'i') r++;
            while (r < n && word[r] == 'o') r++;
            while (r < n && word[r] == 'u') r++;
            if (word[r - 1] == 'u') res = max(res, r - l);
            while (r < n && word[r] != 'a') r++;
            l = r;
        }
        return res;
    }
};