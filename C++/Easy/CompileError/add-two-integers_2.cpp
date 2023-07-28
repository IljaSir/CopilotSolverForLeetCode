class Solution {
public:
    int sum(int num1, int num2) {
        
        int sum = num1 ^ num2;
        int carry = (num1 & num2) << 1;
        if (carry == 0) {
            return sum;
        } else {
            return sum(sum, carry);
        }
    }
};