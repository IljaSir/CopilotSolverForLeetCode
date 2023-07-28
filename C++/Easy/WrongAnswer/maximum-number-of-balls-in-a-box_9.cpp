class Solution {
public:
    int countBalls(int lowLimit, int highLimit) {
        
        int max = 0, maxCount = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            int sum = 0;
            int num = i;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            if (sum > max) {
                max = sum;
                maxCount = 1;
            } else if (sum == max) {
                maxCount++;
            }
        }
        return maxCount;
    }
};