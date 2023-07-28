class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        
        int[] result = new int[2];
        int total = 0;
        for(char c : s.toCharArray()) {
            int w = widths[c - 'a'];
            if (total + w > 100) {
                result[0]++;
                total = w;
            } else {
                total += w;
            }
        }
        result[1] = total;
        result[0]++;
        return result;
    }
}