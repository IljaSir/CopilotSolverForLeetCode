class Solution {
    public int minimumSwap(String s1, String s2) {
        
        int count = 0;
        int[] xy = new int[2];
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == 'x' && s2.charAt(i) == 'y') {
                xy[0]++;
            } else if (s1.charAt(i) == 'y' && s2.charAt(i) == 'x') {
                xy[1]++;
            }
        }
        count += xy[0] / 2 + xy[1] / 2;
        xy[0] %= 2;
        xy[1] %= 2;
        if (xy[0] != xy[1]) {
            return -1;
        }
        count += xy[0] * 2;
        return count;
    }
}