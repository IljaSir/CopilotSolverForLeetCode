class Solution {
public:
    int smallestRepunitDivByK(int k) {
        
        int n = 1;
        int len = 1;
        while (n % k != 0) {
            n = n * 10 + 1;
            len++;
            if (len > k) return -1;
        }
        return len;
    }
};