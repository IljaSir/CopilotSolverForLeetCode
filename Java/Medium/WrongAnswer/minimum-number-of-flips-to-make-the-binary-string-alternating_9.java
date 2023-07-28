class Solution {
    public int minFlips(String s) {
        
        int n = s.length();
        int flip = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) != (i % 2 == 0 ? '0' : '1')) {
                ++flip;
            }
        }
        min = Math.min(min, flip);
        flip = 0;
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) != (i % 2 == 0 ? '1' : '0')) {
                ++flip;
            }
        }
        min = Math.min(min, flip);
        return min;
    }
}