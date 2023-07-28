class Solution {
public:
    int minimumSum(int num) {
        
        int a = num / 100;
        int b = num % 100;
        int c = num / 10;
        int d = num % 10;
        int min = a + b;
        if (c + d < min) min = c + d;
        if (a + c < min) min = a + c;
        if (b + d < min) min = b + d;
        if (a + d < min) min = a + d;
        if (b + c < min) min = b + c;
        return min;
    }
};