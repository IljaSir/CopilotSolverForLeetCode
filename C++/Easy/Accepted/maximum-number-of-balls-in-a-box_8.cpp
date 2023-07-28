class Solution {
public:
    int countBalls(int lowLimit, int highLimit) {
        
        int max = 0;
        int count[100000] = {0};
        for (int i = lowLimit; i <= highLimit; i++) {
            int sum = 0;
            int num = i;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            count[sum]++;
            if (count[sum] > max) {
                max = count[sum];
            }
        }
        return max;
    }
};