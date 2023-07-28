class Solution {
public:
    int countDigits(int num) {
        
        int count = 0;
        int temp = num;
        while (temp > 0) {
            int digit = temp % 10;
            if (digit != 0 && num % digit == 0) {
                count++;
            }
            temp = temp / 10;
        }
        return count;
    }
    int selfDividingNumbers(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (countDigits(i) > 0) {
                count++;
            }
        }
        return count;
    }
};