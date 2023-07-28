class Solution {
public:
    bool canConstruct(string s, int k) {
        
        if (k > s.length()) {
            return false;
        }
        vector<int> count(26, 0);
        for (auto c : s) {
            count[c - 'a']++;
        }
        int odd = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 == 1) {
                odd++;
            }
        }
        return odd <= k;
    }
};