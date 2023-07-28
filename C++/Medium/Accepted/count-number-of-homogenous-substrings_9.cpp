class Solution {
public:
    int countHomogenous(string s) {
        
        int result = 0;
        int len = 0;
        char pre = 0;
        for (auto c : s) {
            if (c == pre) {
                len++;
            } else {
                pre = c;
                len = 1;
            }
            result += len;
            result %= 1000000007;
        }
        return result;
    }
};