class Solution {
public:
    bool judgeSquareSum(int c) {
        
        int a = 0, b = sqrt(c);
        while (a <= b) {
            int sum = a * a + b * b;
            if (sum == c) {
                return true;
            }
            if (sum < c) {
                a++;
            } else {
                b--;
            }
        }
        return false;
    }
};