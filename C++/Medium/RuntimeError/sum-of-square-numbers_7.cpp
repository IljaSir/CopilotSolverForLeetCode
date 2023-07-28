class Solution {
public:
    bool judgeSquareSum(int c) {
        
        int a = 0, b = sqrt(c);
        while (a <= b) {
            int tmp = a * a + b * b;
            if (tmp == c)
                return true;
            else if (tmp < c)
                a++;
            else
                b--;
        }
        return false;
    }
};