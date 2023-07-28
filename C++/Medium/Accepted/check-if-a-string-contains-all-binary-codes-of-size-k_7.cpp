class Solution {
public:
    bool hasAllCodes(string s, int k) {
        
        int n = s.length();
        int m = 1 << k;
        bool* has = new bool[m];
        for (int i = 0; i < m; i++) {
            has[i] = false;
        }
        int num = 0;
        for (int i = 0; i < n; i++) {
            num = (num << 1) + (s[i] - '0');
            if (i >= k - 1) {
                num &= (m - 1);
                has[num] = true;
            }
        }
        for (int i = 0; i < m; i++) {
            if (!has[i]) {
                return false;
            }
        }
        return true;
    }
};