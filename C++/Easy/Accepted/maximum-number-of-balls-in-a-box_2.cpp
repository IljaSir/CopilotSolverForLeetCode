class Solution {
public:
    int countBalls(int lowLimit, int highLimit) {
        
        int count[46] = {0};
        for (int i = lowLimit; i <= highLimit; i++) {
            int sum = 0;
            int n = i;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            count[sum]++;
        }
        int max = 0;
        for (int i = 0; i < 46; i++) {
            if (count[i] > max) max = count[i];
        }
        return max;
    }
};