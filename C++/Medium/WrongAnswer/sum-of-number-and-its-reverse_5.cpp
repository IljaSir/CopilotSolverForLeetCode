class Solution {
public:
    bool sumOfNumberAndReverse(int num) {
        
        if(num < 10) return true;
        if(num % 10 == 0) return false;
        int rev = 0;
        int n = num;
        while(n > 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return rev != num;
    }
};