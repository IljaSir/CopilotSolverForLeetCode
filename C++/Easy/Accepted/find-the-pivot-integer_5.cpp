class Solution {
public:
    int pivotInteger(int n) {
        
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        int left = 0;
        int right = sum;
        for (int i = 1; i <= n; i++) {
            right -= i;
            if (left == right) {
                return i;
            }
            left += i;
        }
        return -1;
    }
};