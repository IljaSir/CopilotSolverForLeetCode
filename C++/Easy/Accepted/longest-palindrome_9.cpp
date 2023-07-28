class Solution {
public:
    int longestPalindrome(string s) {
        
        unordered_map<char, int> m;
        for (auto c: s) {
            m[c]++;
        }
        int odd = 0;
        for (auto& [_, count]: m) {
            if (count & 1) {
                odd++;
            }
        }
        return odd ? s.size() - odd + 1 : s.size();
    }
};