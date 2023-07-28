class Solution {
public:
    int countNumbersWithUniqueDigits(int n) {
        
        if(n == 0) return 1;
        if(n == 1) return 10;
        int res = 10;
        int base = 9;
        int available = 9;
        while(n > 1 && available > 0) {
            base = base * available;
            res += base;
            available--;
            n--;
        }
        return res;
    }
};