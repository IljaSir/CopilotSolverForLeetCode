class Solution {
public:
    int longestBeautifulSubstring(string word) {
        
        int n = word.size();
        int ans = 0;
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && word[j] == word[i]) j++;
            if (word[i] != 'a') break;
            int k = j;
            while (k < n && word[k] > word[k - 1]) k++;
            if (word[k - 1] != 'u') {
                i = k;
                continue;
            }
            ans = max(ans, k - i);
            i = j;
        }
        return ans;
    }
};