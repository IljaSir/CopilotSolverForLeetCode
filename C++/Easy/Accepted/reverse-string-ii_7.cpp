class Solution {
public:
    string reverseStr(string s, int k) {
        
        int len = s.length();
        for (int i = 0; i < len; i += 2 * k) {
            int j = i + k - 1;
            if (j >= len) {
                j = len - 1;
            }
            int m = i, n = j;
            while (m < n) {
                swap(s[m], s[n]);
                m++;
                n--;
            }
        }
        return s;
    }
};