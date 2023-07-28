class Solution {
public:
    int longestPalindrome(vector<string>& words) {
        
        int n = words.size();
        int mask[n];
        for (int i = 0; i < n; i++) {
            mask[i] = 0;
            for (int j = 0; j < 2; j++) {
                mask[i] |= 1 << (words[i][j] - 'a');
            }
        }
        vector<int> v(1 << 16, 0);
        for (int i = 0; i < n; i++) {
            v[mask[i]] = max(v[mask[i]], (int)words[i].length());
        }
        int ans = 0;
        for (int i = 0; i < (1 << 16); i++) {
            for (int j = i; j < (1 << 16); j++) {
                if ((i | j) == (1 << 16) - 1) {
                    ans = max(ans, v[i] + v[j]);
                }
            }
        }
        return ans;
    }
};