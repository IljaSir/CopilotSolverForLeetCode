class Solution {
public:
    int pivotInteger(int n) {
        
        int sum = 0;
        int sum2 = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
            sum2 += n - i + 1;
            if (sum == sum2) {
                return i;
            }
        }
        return -1;
    }
};