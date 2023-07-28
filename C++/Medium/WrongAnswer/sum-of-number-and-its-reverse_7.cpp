class Solution {
public:
    bool sumOfNumberAndReverse(int num) {
        
        int rev = 0;
        int temp = num;
        while(temp) {
            rev = rev * 10 + temp % 10;
            temp /= 10;
        }
        if (rev + num == num) {
            return true;
        }
        return false;
    }
};