class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        
        int line = 1;
        int width = 0;
        for (int i = 0; i < s.length(); i++) {
            int w = widths[s.charAt(i) - 'a'];
            if (width + w > 100) {
                line++;
                width = w;
            } else {
                width += w;
            }
        }
        return new int[]{line, width};
    }
}