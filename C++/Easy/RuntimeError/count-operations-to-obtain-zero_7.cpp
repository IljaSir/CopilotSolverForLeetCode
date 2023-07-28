class Solution {
public:
    int countOperations(int num1, int num2) {
        
        if (num1 > num2) {
            swap(num1, num2);
        }
        int result = 0;
        while (num2 > num1) {
            result += num2 / num1;
            num2 %= num1;
            swap(num1, num2);
        }
        return result;
    }
};