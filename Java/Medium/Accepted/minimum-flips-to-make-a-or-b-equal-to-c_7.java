class Solution {
    public int minFlips(int a, int b, int c) {
        
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int x = a & 1;
            int y = b & 1;
            int z = c & 1;
            if (z == 0) {
                res += x + y;
            } else {
                if (x == 0 && y == 0) {
                    res++;
                }
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return res;
    }
}