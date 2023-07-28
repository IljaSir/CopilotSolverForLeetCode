class Solution {
public:
    int getLucky(string s, int k) {
        
        int res = 0;
        for (char c : s) {
            res += (c - 'a' + 1) / 10 + (c - 'a' + 1) % 10;
        }
        while (--k) {
            int tmp = res;
            res = 0;
            while (tmp) {
                res += tmp % 10;
                tmp /= 10;
            }
        }
        return res;
    }
};