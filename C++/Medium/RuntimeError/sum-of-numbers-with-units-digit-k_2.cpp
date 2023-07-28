class Solution {
public:
    int minimumNumbers(int num, int k) {
        
        if (k == 0) {
            return num == 0 ? 1 : -1;
        }
        if (num == 0) {
            return 0;
        }
        int d = num % 10;
        if (d == k) {
            return minimumNumbers(num / 10, k);
        }
        if (d < k) {
            return 1 + minimumNumbers(num + 10 - d, k);
        }
        return 1 + minimumNumbers(num - d, k);
    }
};