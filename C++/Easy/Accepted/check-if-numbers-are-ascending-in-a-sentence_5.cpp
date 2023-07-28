class Solution {
public:
    bool areNumbersAscending(string s) {
        
        int last = -1;
        int i = 0, n = s.length();
        while (i < n) {
            if (s[i] >= '0' && s[i] <= '9') {
                int num = 0;
                while (i < n && s[i] >= '0' && s[i] <= '9') {
                    num = num * 10 + s[i++] - '0';
                }
                if (num <= last) {
                    return false;
                }
                last = num;
            } else {
                ++i;
            }
        }
        return true;
    }
};