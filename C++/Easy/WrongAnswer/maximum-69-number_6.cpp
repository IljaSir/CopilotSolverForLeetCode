class Solution {
public:
    int maximum69Number (int num) {
        
        int res = 0, base = 1;
        while (num) {
            res += (num % 10 == 6 ? 9 : num % 10) * base;
            base *= 10;
            num /= 10;
        }
        return res;
    }
};