class Solution {
    public int minimumSwap(String s1, String s2) {
        
        int xy = 0, yx = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == 'x' && s2.charAt(i) == 'y') {
                xy++;
            } else if (s1.charAt(i) == 'y' && s2.charAt(i) == 'x') {
                yx++;
            }
        }
        int res = xy / 2 + yx / 2;
        xy %= 2;
        yx %= 2;
        if (xy == 1 && yx == 1) {
            res += 2;
        } else if (xy == 1 || yx == 1) {
            return -1;
        }
        return res;
    }
}