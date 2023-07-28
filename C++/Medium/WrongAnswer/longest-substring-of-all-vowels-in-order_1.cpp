class Solution {
public:
    int longestBeautifulSubstring(string word) {
        
        int n = word.length();
        if (n < 5) return 0;
        int i = 0;
        int j = 0;
        int res = 0;
        while (i < n) {
            while (i < n && word[i] != 'a') i++;
            if (i == n) break;
            j = i;
            while (j < n && word[j] == 'a') j++;
            if (j == n) break;
            while (j < n && word[j] == 'e') j++;
            while (j < n && word[j] == 'i') j++;
            while (j < n && word[j] == 'o') j++;
            while (j < n && word[j] == 'u') j++;
            if (j == n) break;
            res = max(res, j - i);
            i = j;
        }
        return res;
    }
};