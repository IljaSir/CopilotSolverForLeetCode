class Solution {
public:
    int pivotInteger(int n) {
        
        if (n == 1) return 1;
        for (int i = 2; i <= n; i++) {
            int sum1 = 0, sum2 = 0;
            for (int j = 1; j < i; j++) {
                sum1 += j;
            }
            for (int j = i + 1; j <= n; j++) {
                sum2 += j;
            }
            if (sum1 == sum2) return i;
        }
        return -1;
    }
};