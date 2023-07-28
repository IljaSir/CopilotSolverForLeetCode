class Solution {
public:
    int passThePillow(int n, int time) {
        
        int c = time / (n - 1);
        int r = time % (n - 1);
        if (c % 2 == 0) {
            return r + 1;
        }
        else {
            return n - r;
        }
    }
};