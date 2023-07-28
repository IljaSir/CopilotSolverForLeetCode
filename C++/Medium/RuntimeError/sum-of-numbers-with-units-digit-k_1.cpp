class Solution {
public:
    int minimumNumbers(int num, int k) {
        
        if (num == 0) return 0;
        int res = 0;
        while (num > 0) {
            if (num % 10 < k) {
                res += k - num % 10;
                num = num / 10 + 1;
            } else if (num % 10 > k) {
                res += num % 10 - k;
                num = num / 10;
            } else {
                num = num / 10;
            }
        }
        return res;
    }
};