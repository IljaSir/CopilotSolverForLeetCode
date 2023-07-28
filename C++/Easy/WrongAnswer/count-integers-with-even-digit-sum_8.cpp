class Solution {
public:
    int countEven(int num) {
        
        int digit = 0;
        int res = 0;
        while(num) {
            digit += num % 10;
            num /= 10;
        }
        return digit % 2 == 0;
    }
    int countEvenDigits(int num) {
        int res = 0;
        for(int i = 1; i <= num; i++) {
            res += countEven(i);
        }
        return res;
    }
};