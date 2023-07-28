class Solution {
public:
    int twoEggDrop(int n) {
        
        int m = 0;
        while (n > 0) {
            m++;
            n -= m;
        }
        return m;
    }
};