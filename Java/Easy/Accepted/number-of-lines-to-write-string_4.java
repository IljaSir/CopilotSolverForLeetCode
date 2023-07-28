class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        
        int[] result = new int[2];
        int line = 1;
        int width = 0;
        for (char c : s.toCharArray()) {
            int w = widths[c - 'a'];
            if (width + w > 100) {
                line++;
                width = w;
            } else {
                width += w;
            }
        }
        result[0] = line;
        result[1] = width;
        return result;
    }
}