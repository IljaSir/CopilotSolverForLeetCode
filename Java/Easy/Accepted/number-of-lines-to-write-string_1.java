class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        
        int lines = 1;
        int cur = 0;
        for (char c : s.toCharArray()) {
            int w = widths[c - 'a'];
            if (cur + w > 100) {
                lines++;
                cur = 0;
            }
            cur += w;
        }
        return new int[]{lines, cur};
    }
}