class Solution {
public:
    int longestPalindrome(string s) {
        
        int freq[128] = {0};
        for (char c : s) {
            freq[c]++;
        }
        int odd = 0;
        for (int f : freq) {
            if (f % 2 == 1) {
                odd++;
            }
        }
        return s.size() - odd + (odd > 0);
    }
};