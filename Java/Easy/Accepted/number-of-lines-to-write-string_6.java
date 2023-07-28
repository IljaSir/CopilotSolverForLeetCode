class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        
        int line = 1;
        int length = 0;
        for (char c: s.toCharArray()) {
            int width = widths[c - 'a'];
            if (length + width > 100) {
                line++;
                length = width;
            } else {
                length += width;
            }
        }
        return new int[]{line, length};
    }
}