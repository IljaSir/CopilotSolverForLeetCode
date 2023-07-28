class Solution {
    public int minimumSwap(String s1, String s2) {
        
        int count = 0;
        int xy = 0;
        int yx = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == 'x' && s2.charAt(i) == 'y') {
                xy++;
            } else if (s1.charAt(i) == 'y' && s2.charAt(i) == 'x') {
                yx++;
            }
        }
        count += xy / 2 + yx / 2;
        xy %= 2;
        yx %= 2;
        if ((xy + yx) % 2 != 0) return -1;
        if (xy == 1 && yx == 1) {
            count += 2;
        }
        return count;
    }
}