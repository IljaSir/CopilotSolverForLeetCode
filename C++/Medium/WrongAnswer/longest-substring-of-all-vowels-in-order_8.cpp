class Solution {
public:
    int longestBeautifulSubstring(string word) {
        
        int n = word.size();
        int ans = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            char c = word[i];
            while (j < n && word[j] >= c) {
                c = word[j];
                j++;
            }
            if (c == 'u') {
                ans = max(ans, j - i);
            }
            i = j - 1;
        }
        return ans;
    }
};