class Solution {
public:
    int divisorSubstrings(int num, int k) {
        
        int res = 0;
        int n = 0;
        while (num) {
            n = (num % 10) * pow(10, k - 1) + n;
            if (num % n == 0) {
                ++res;
            }
            num /= 10;
        }
        return res;
    }
};