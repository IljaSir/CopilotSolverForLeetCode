class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        
        int n = s.length();
        long[] shift = new long[n];
        for (int i = 0; i < shifts.length; i++) {
            shift[shifts[i][0]] += shifts[i][2];
            if (shifts[i][1] != n-1) {
                shift[shifts[i][1] + 1] -= shifts[i][2];
            }
        }
        for (int i = 1; i < n; i++) {
            shift[i] += shift[i-1];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append((char) ((s.charAt(i) - 'a' + shift[i]) % 26 + 'a'));
        }
        return sb.toString();
    }
}