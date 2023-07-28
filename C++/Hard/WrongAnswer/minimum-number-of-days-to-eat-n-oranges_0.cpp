class Solution {
public:
    int minDays(int n) {
        
        if (n <= 1) return n;
        if (n % 2 == 0) return 1 + minDays(n / 2);
        if (n % 3 == 0) return 1 + minDays(n / 3);
        return 1 + minDays(n - 1);
    }
};