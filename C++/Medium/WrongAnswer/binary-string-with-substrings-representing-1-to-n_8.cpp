class Solution {
public:
    bool queryString(string s, int n) {
        
        int m = s.size() - 1;
        for (int i = n; i > n/2; i--) {
            int j = i;
            while (j > 0) {
                if (s[m - j % 2] != '1') {
                    return false;
                }
                j /= 2;
            }
        }
        return true;
    }
};