class Solution {
public:
    int countOperations(int num1, int num2) {
        
        if (num1 == num2) {
            return num1 == 0 ? 0 : 1;
        }
        if (num1 > num2) {
            swap(num1, num2);
        }
        int count = 0;
        while (num1 != 0) {
            count += num2 / num1;
            num2 %= num1;
            swap(num1, num2);
        }
        return count;
    }
};