class Solution {
public:
    int minSteps(int n) {
        
        int i, j;
        int minStep = 0;
        for (i = 2; i <= n; i++) {
            while (n % i == 0) {
                minStep += i;
                n /= i;
            }
        }
        return minStep;
    }
};