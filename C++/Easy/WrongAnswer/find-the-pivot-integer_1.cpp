class Solution {
public:
    int pivotInteger(int n) {
        
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return -1;
        }
        int half = sum / 2;
        int sum2 = 0;
        for (int i = 1; i <= n; i++) {
            sum2 += i;
            if (sum2 == half) {
                return i;
            }
        }
        return -1;
    }
};