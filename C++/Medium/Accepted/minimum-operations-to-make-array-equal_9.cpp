class Solution {
public:
    int minOperations(int n) {
        
        int sum = 0;
        int avg = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            sum += (2 * i) + 1;
        }
        avg = sum / n;
        for (int i = 0; i < n / 2; i++) {
            count += abs((2 * i) + 1 - avg);
        }
        return count;
    }
};