class Solution {
public:
    int minimizeXor(int num1, int num2) {
        
        int x = num1 ^ num2;
        int n = 0;
        while(x) {
            x >>= 1;
            n++;
        }
        return num2 ^ ((1 << n) - 1);
    }
};