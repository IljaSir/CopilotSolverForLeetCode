class Solution {
    public int minimumSwap(String s1, String s2) {
        
        int xy = 0, yx = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                continue;
            }
            if (s1.charAt(i) == 'x') {
                xy++;
            } else {
                yx++;
            }
        }
        int ret = xy / 2 + yx / 2;
        xy %= 2;
        yx %= 2;
        if (xy == 1 && yx == 1) {
            ret += 2;
        } else if (xy == 1 || yx == 1) {
            return -1;
        }
        return ret;
    }
}