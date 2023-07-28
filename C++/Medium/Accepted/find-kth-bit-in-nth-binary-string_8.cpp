class Solution {
public:
    char findKthBit(int n, int k) {
        
        if(n == 1) return '0';
        int len = pow(2, n - 1);
        if(k == len) return '1';
        if(k < len) return findKthBit(n - 1, k);
        return findKthBit(n - 1, len * 2 - k) == '0' ? '1' : '0';
    }
};