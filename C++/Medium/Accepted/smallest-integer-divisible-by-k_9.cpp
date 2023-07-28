class Solution {
public:
    int smallestRepunitDivByK(int k) {
        
        if (k % 2 == 0 || k % 5 == 0) return -1; // 2, 5 are not in 1..9
        int n = 1, len = 1;
        while (n % k != 0) {
            n = (n * 10 + 1) % k;
            len++;
        }
        return len;
    }
};