class Solution {
public:
    int pivotInteger(int n) {
        
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= i; j++) {
                sum += j;
            }
            for (int j = i + 1; j <= n; j++) {
                sum -= j;
            }
            if (sum == 0) {
                return i;
            }
        }
        return -1;
    }
};