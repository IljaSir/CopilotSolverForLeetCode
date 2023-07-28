class Solution {
public:
    int minimumOneBitOperations(int n) {
        
        int res = 0;
        int k = 0;
        while (n) {
            res += (n % 2) * (1 << k);
            k++;
            n >>= 1;
        }
        return res;
    }
};