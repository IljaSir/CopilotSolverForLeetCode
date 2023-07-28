class Solution {
public:
    int countDigits(int num) {
        
        int count = 0;
        while (num) {
            int digit = num % 10;
            if (digit != 0 && num % digit == 0) {
                count++;
            }
            num /= 10;
        }
        return count;
    }
    int digitsCount(int num) {
        int count = 0;
        while (num) {
            count++;
            num /= 10;
        }
        return count;
    }
    int digitsDivideNumber(int num) {
        int digits = digitsCount(num);
        int count = 0;
        for (int i = 0; i < digits; i++) {
            int digit = num % 10;
            if (digit != 0 && num % digit == 0) {
                count++;
            }
            num /= 10;
        }
        return count;
    }
    int digitsDivideNumber2(int num) {
        int count = 0;
        while (num) {
            int digit = num % 10;
            if (digit != 0 && num % digit == 0) {
                count++;
            }
            num /= 10;
        }
        return count;
    }
    int digitsDivideNumber3(int num) {
        int count = 0;
        while (num) {
            int digit = num % 10;
            if (digit != 0 && num % digit == 0) {
                count++;
            }
            num /= 10;
        }
        return count;
    }
    int digitsDivideNumber4(int num) {
        int count = 0;
        while (num) {
            int digit = num % 10;
            if (digit != 0 && num % digit == 0) {
                count++;
            }
            num /= 10;
        }
        return count;
    }
};