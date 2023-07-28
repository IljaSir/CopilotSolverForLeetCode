class Solution {
public:
    int countDigits(int num) {
        
        int count = 0;
        while(num) {
            count++;
            num /= 10;
        }
        return count;
    }
    int digitsDivide(int num) {
        int count = 0;
        int digits = countDigits(num);
        int temp = num;
        while(temp) {
            int digit = temp % 10;
            if(digit && (num % digit == 0)) {
                count++;
            }
            temp /= 10;
        }
        return count;
    }
};