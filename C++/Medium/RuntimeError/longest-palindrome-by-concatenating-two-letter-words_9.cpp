class Solution {
public:
    int longestPalindrome(vector<string>& words) {
        
        vector<int> m(26, 0);
        for (auto &w : words) {
            int mask = 0;
            for (auto &c: w) {
                mask |= 1 << (c - 'a');
            }
            m[mask]++;
        }
        int res = 0;
        for (int i = 0; i < m.size(); i++) {
            for (int j = i; j < m.size(); j++) {
                if (m[i] > 0 && m[j] > 0 && (i ^ j) == 0) {
                    res += m[i] * m[j];
                    if (i == j) {
                        res -= m[i];
                    }
                }
            }
        }
        return res;
    }
};