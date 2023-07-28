class Solution {
public:
    int smallestRepunitDivByK(int k) {
        
        int n = 1;
        for (int i = 1; i <= k; i++) {
            if (n % k == 0) return i;
            n = n * 10 + 1;
        }
        return -1;
    }
};