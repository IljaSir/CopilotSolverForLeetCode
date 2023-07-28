class Solution {
public:
    int smallestEvenMultiple(int n) {
        
        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            if (n % i == 0) {
                ans = i;
                break;
            }
        }
        if (ans % 2 == 1) {
            ans *= 2;
        }
        return ans;
    }
};