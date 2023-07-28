class Solution {
public:
    int minimumNumbers(int num, int k) {
        
        int ret = 0;
        for (int i = 0; i < 10; i++) {
            int d = k - i;
            if (d < 0) d += 10;
            if (num < d) continue;
            int m = (num - d) / 10;
            if (m * 10 + d == num) {
                ret = m + 1;
                break;
            }
        }
        return ret;
    }
    int sumOfDigits(int num) {
        int ret = 0;
        while (num) {
            ret += num % 10;
            num /= 10;
        }
        return ret % 2;
    }
};