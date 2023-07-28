class Solution {
public:
    bool isSameAfterReversals(int num) {
        
        int reversed1 = 0;
        int reversed2 = 0;
        int temp = num;
        while (temp != 0) {
            reversed1 = reversed1 * 10 + temp % 10;
            temp /= 10;
        }
        temp = reversed1;
        while (temp != 0) {
            reversed2 = reversed2 * 10 + temp % 10;
            temp /= 10;
        }
        return reversed2 == num;
    }
};