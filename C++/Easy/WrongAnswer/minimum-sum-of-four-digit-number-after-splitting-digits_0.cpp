class Solution {
public:
    int minimumSum(int num) {
        
        int a = num / 1000;
        int b = (num / 100) % 10;
        int c = (num / 10) % 10;
        int d = num % 10;
        int res = min({(a + b) * 10 + (c + d), (a + c) * 10 + (b + d), (a + d) * 10 + (b + c)});
        return res;
    }
};