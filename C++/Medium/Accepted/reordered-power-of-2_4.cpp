class Solution {
public:
    bool reorderedPowerOf2(int n) {
        
        int c = count(n);
        for (int i = 0; i < 31; i++) {
            if (c == count(1 << i)) return true;
        }
        return false;
    }
    int count(int n) {
        int c = 0;
        for (; n; n /= 10) c += pow(10, n % 10);
        return c;
    }
};