class Solution {
public:
    int minDays(int n) {
        
        if (n <= 1) return n;
        if (n % 2 == 0) return minDays(n / 2) + 1;
        if (n % 3 == 0) return minDays(n / 3) + 1;
        return minDays(n - 1) + 1;
    }
};