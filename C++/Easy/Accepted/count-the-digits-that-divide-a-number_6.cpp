class Solution {
public:
    int countDigits(int num) {
        
        int count = 0;
        int temp = num;
        while (temp > 0) {
            int digit = temp % 10;
            temp = temp / 10;
            if (digit != 0 && num % digit == 0) {
                count++;
            }
        }
        return count;
    }
};