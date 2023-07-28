class Solution {
public:
    int numberOfCuts(int n) {
        
        if (n <= 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 3;
        return 1 + numberOfCuts(n - 2);
    }
};