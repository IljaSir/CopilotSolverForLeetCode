class Solution {
public:
    int smallestRepunitDivByK(int k) {
        
        int n = 0;
        int i = 1;
        while (n % k != 0) {
            n = (n * 10 + 1) % k;
            if (n == 0) {
                return i;
            }
            ++i;
        }
        return -1;
    }
};