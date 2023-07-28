class Solution {
public:
    int minimizeXor(int num1, int num2) {
        
        int x = num2 ^ num1;
        int i = 0;
        while(x) {
            i++;
            x = x >> 1;
        }
        int mask = (1 << i) - 1;
        return num2 & mask;
    }
};