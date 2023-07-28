class Solution {
public:
    int countOperations(int num1, int num2) {
        
        if (num1 < num2) {
            return countOperations(num2, num1);
        }
        if (num2 == 0) {
            return 0;
        }
        int count = 0;
        while (num1 > 0) {
            count += num1 / num2;
            num1 %= num2;
            if (num1 < num2) {
                swap(num1, num2);
            }
        }
        return count;
    }
};