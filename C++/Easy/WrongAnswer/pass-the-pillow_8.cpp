class Solution {
public:
    int passThePillow(int n, int time) {
        
        int m = 2 * n - 2;
        int pos = (time - 1) % m;
        if (pos < n) return pos + 1;
        pos = m - pos;
        return pos + 1;
    }
};