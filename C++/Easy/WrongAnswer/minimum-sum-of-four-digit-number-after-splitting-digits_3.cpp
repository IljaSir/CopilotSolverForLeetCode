class Solution {
public:
    int minimumSum(int num) {
        
        int a = num / 100;
        int b = num % 100;
        int c = num / 10;
        int d = num % 10;
        return min(min(a + b, c + d), min((a / 10) + (a % 10) + b, a + (b / 10) + (b % 10)));
    }
};