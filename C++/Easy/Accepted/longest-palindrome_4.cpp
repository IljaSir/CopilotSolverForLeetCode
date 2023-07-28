class Solution {
public:
    int longestPalindrome(string s) {
        
        int n = s.size();
        int ans = 0;
        int odd = 0;
        unordered_map<char, int> m;
        for (int i = 0; i < n; i++) {
            m[s[i]]++;
        }
        for (auto x : m) {
            if (x.second % 2 == 0) {
                ans += x.second;
            } else {
                odd = 1;
                ans += x.second - 1;
            }
        }
        return ans + odd;
    }
};