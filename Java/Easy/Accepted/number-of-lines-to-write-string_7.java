class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        
        int[] result = new int[2];
        int sum = 0;
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            int width = widths[s.charAt(i) - 'a'];
            if (sum + width > 100) {
                count++;
                sum = 0;
            }
            sum += width;
        }
        result[0] = count;
        result[1] = sum;
        return result;
    }
}