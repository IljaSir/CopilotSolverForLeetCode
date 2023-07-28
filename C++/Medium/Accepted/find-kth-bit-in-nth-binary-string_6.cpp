class Solution {
public:
    char findKthBit(int n, int k) {
        
        if (n == 1) {
            return '0';
        }
        int len = (1 << n) - 1;
        int mid = len / 2;
        if (k == mid + 1) {
            return '1';
        } else if (k < mid + 1) {
            return findKthBit(n - 1, k);
        } else {
            return findKthBit(n - 1, len - k + 1) == '0' ? '1' : '0';
        }
    }
};