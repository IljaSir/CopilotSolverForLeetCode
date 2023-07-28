class Solution {
public:
    bool isSameAfterReversals(int num) {
        
        int reversed1 = 0;
        while(num > 0){
            reversed1 = reversed1 * 10 + num % 10;
            num /= 10;
        }
        int reversed2 = 0;
        while(reversed1 > 0){
            reversed2 = reversed2 * 10 + reversed1 % 10;
            reversed1 /= 10;
        }
        return reversed2 == num;
    }
};