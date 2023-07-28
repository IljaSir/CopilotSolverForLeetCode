class Solution {
public:
    int countOperations(int num1, int num2) {
        
        if(num1 > num2) {
            swap(num1, num2);
        }
        if(num2 == 0) {
            return 0;
        }
        int res = 0;
        while(num1 != 0) {
            res += num2 / num1;
            num2 %= num1;
            swap(num1, num2);
        }
        return res - 1;
    }
};