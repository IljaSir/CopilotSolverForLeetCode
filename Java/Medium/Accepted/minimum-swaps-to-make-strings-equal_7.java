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
        return (xy + yx) % 2 == 1 ? -1 : xy / 2 + yx / 2 + xy % 2 + yx % 2;
    }
}