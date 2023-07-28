class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        
        int[] result = new int[2];
        int line = 0, lastLine = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int width = widths[c - 'a'];
            if (lastLine + width > 100) {
                line++;
                lastLine = width;
            } else {
                lastLine += width;
            }
        }
        result[0] = line + 1;
        result[1] = lastLine;
        return result;
    }
}