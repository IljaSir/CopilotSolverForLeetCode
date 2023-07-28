class Solution {
public:
    int minimumOneBitOperations(int n) {
        
        return n > 0 ? (1 << (32 - __builtin_clz(n))) - 1 - minimumOneBitOperations(n & (n - 1)) : 0;
    }
};