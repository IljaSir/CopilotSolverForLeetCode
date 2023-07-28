class Solution {
public:
    bool canConstruct(string s, int k) {
        
        int n = s.length();
        if (n < k) return false;
        if (n == k) return true;
        int freq[26] = {0};
        for (char c : s) {
            freq[c - 'a']++;
        }
        int odd = 0;
        for (int i = 0; i < 26; ++i) {
            if (freq[i] & 1) {
                odd++;
            }
        }
        return odd <= k;
    }
};