class Solution {
    public String makeGood(String s) {
        
        char[] cs = s.toCharArray();
        int i = 0;
        for (int j = 0; j < cs.length; j++) {
            if (i > 0 && Math.abs(cs[j] - cs[i - 1]) == 32) {
                i--;
            } else {
                cs[i++] = cs[j];
            }
        }
        return new String(cs, 0, i);
    }
}