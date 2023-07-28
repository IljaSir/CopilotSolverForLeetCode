class Solution {
public:
    int longestPalindrome(string s) {
        
        unordered_map<char, int> m;
        int odd = 0;
        for (auto c: s) {
            m[c]++;
        }
        for (auto p: m) {
            if (p.second % 2 == 1) {
                odd++;
            }
        }
        if (odd == 0) {
            return s.size();
        }
        return s.size() - odd + 1;
    }
};