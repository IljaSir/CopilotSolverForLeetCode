class Solution {
public:
    int largestInteger(int num) {
        
        int res = 0;
        int n = 0;
        while (num) {
            int d = num % 10;
            num /= 10;
            if (d % 2 == 0) {
                res += d * pow(10, n);
                ++n;
            }
        }
        while (num) {
            int d = num % 10;
            num /= 10;
            if (d % 2 == 1) {
                res += d * pow(10, n);
                ++n;
            }
        }
        return res;
    }
};