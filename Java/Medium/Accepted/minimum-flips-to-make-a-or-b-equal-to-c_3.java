class Solution {
    public int minFlips(int a, int b, int c) {
        
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int bitA = (a >> i) & 1;
            int bitB = (b >> i) & 1;
            int bitC = (c >> i) & 1;
            if (bitC == 1) {
                if (bitA == 0 && bitB == 0) {
                    res++;
                }
            } else {
                if (bitA == 1) {
                    res++;
                }
                if (bitB == 1) {
                    res++;
                }
            }
        }
        return res;
    }
}