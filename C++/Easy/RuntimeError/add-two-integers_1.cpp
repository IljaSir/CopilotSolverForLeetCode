class Solution {
public:
    int sum(int num1, int num2) {
        
        int carry = 0;
        while (num2 != 0) {
            carry = num1 & num2;
            num1 = num1 ^ num2;
            num2 = carry << 1;
        }
        return num1;
    }
};