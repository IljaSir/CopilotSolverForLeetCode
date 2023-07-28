class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        
        int n = s.length();
        long[] sums = new long[n];
        for (int i = n - 1; i >= 0; i--) {
            sums[i] = (i < n - 1 ? sums[i + 1] : 0) + shifts[i][2];
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            chars[i] = (char) ((chars[i] - 'a' + sums[i]) % 26 + 'a');
        }
        return new String(chars);
    }
}