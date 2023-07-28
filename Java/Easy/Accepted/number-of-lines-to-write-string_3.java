class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        
        int lines = 1;
        int lastLine = 0;
        for (char c : s.toCharArray()) {
            int width = widths[c - 'a'];
            lastLine += width;
            if (lastLine > 100) {
                lines++;
                lastLine = width;
            }
        }
        return new int[]{lines, lastLine};
    }
}