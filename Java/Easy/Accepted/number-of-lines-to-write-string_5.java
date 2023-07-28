class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        
        int sum = 0;
        int line = 1;
        for (char c : s.toCharArray()) {
            int w = widths[c - 'a'];
            if (sum + w > 100) {
                line++;
                sum = w;
            } else {
                sum += w;
            }
        }
        return new int[] { line, sum };
    }
}