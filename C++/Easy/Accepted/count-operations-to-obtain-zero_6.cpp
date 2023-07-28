class Solution {
public:
    int countOperations(int num1, int num2) {
        
        if (num1 < num2) {
            std::swap(num1, num2);
        }
        int result = 0;
        while (num2 > 0) {
            result += num1 / num2;
            num1 = num1 % num2;
            std::swap(num1, num2);
        }
        return result;
    }
};