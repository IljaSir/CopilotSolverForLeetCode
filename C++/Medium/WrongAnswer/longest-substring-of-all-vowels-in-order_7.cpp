class Solution {
public:
    int longestBeautifulSubstring(string word) {
        
        int l = 0, r = 0;
        int ans = 0;
        int n = word.size();
        while (r < n) {
            if (l == r) {
                if (word[r] != 'a') {
                    l++;
                    r++;
                } else {
                    r++;
                }
            } else {
                if (word[r] >= word[r-1]) {
                    if (word[r] == 'u') {
                        ans = max(ans, r - l + 1);
                        l = r;
                    }
                    r++;
                } else {
                    l = r;
                }
            }
        }
        return ans;
    }
};