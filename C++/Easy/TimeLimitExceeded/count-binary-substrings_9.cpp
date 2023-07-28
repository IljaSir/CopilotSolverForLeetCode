class Solution {
public:
    int countBinarySubstrings(string s) {
        
        int n = s.length();
        int count = 0;
        int p = 0;
        int q = 0;
        for (int i = 0; i < n; i++) {
            p = 0;
            q = 0;
            while (i < n && s[i] == '0') {
                p++;
                i++;
            }
            i--;
            while (i < n && s[i] == '1') {
                q++;
                i++;
            }
            i--;
            count += min(p, q);
        }
        return count;
    }
};