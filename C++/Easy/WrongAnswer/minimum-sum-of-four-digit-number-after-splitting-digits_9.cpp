class Solution {
public:
    int minimumSum(int num) {
        
        int min = 10000;
        for (int i = 0; i < 4; i++) {
            int new1 = num / 1000 * 1000 + num % 1000 / 100 * 100 + num % 100 / 10 * 10 + i;
            int new2 = num / 1000 * 100 + num % 1000 / 100 * 10 + i;
            int sum = new1 + new2;
            if (sum < min) {
                min = sum;
            }
        }
        return min;
    }
};