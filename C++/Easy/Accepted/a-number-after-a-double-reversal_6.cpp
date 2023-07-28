class Solution {
public:
    bool isSameAfterReversals(int num) {
        
        int reversed1 = 0;
        int reversed2 = 0;
        int n = num;
        int i = 0;
        while (n > 0) {
            reversed1 = reversed1 * 10 + n % 10;
            n /= 10;
        }
        n = reversed1;
        while (n > 0) {
            reversed2 = reversed2 * 10 + n % 10;
            n /= 10;
        }
        return reversed2 == num;
    }
};