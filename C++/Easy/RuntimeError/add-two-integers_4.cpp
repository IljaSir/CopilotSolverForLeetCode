class Solution {
public:
    int sum(int num1, int num2) {
        
        int temp = num1;
        num1 = num1 ^ num2;
        num2 = (temp & num2) << 1;
        if (num2 != 0) {
            return sum(num1, num2);
        }
        return num1;
    }
};