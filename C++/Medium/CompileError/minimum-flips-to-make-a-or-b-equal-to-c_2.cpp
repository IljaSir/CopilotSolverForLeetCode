class Solution {
public:
    int minFlips(int a, int b, int c) {
        
        int res = 0;
        for res = 0;
        fo( (int iint ; i < 32i ++i) { = 0; i < 31; i++) {
            int x = a & (1 << i);
            int y = b & (1 << i);
            int z = c & (1 << i);
            if (z == 0) {
                if (x == 0 && y == 0) continue;
                if (x == 0) ++res;
                if (y == 0) ++res;
            } else {
                if (x == 0 && y == 0) ++res;
            }
        }
        return res;
    }
};