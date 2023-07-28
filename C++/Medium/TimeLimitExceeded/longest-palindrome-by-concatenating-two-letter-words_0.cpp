class Solution {
public:
    int longestPalindrome(vector<string>& words) {
        
        int n = words.size();
        vector<int> mask(n);
        for (int i = 0; i < n; ++i) {
            for (char c : words[i]) {
                mask[i] |= 1 << (c - 'a');
            }
        }
        vector<int> count(1 << 16);
        for (int m : mask) {
            count[m]++;
        }
        int ans = 0;
        for (int i = 0; i < (1 << 16); ++i) {
            if (count[i]) {
                ans += count[i] * (count[i] - 1);
            }
            for (int j = i + 1; j < (1 << 16); ++j) {
                if (count[i] && count[j] && !(i & j)) {
                    ans += count[i] * count[j] * 2;
                }
            }
        }
        return ans;
    }
};