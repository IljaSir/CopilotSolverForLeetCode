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
        int ans = 0;
        if (xy % 2 == 1 && yx % 2 == 1) {
            ans += 2;
            xy--;
            yx--;
        }
        ans += (xy + 1) / 2 + (yx + 1) / 2;
        return ans;
    }
}