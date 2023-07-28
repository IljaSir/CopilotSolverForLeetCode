class Solution {
public:
    string repeatLimitedString(string s, int repeatLimit) {
        
        string res;
        int i = 0;
        while (i < s.length()) {
            int j = i + 1;
            while (j < s.length() && s[j] == s[i]) j++;
            int count = j - i;
            while (count > 0) {
                int len = min(count, repeatLimit);
                res += string(len, s[i]);
                count -= len;
            }
            i = j;
        }
        return res;
    }
};