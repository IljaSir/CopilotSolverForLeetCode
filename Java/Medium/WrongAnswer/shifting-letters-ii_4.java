class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        
        char[] ch = s.toCharArray();
        int n = s.length();
        for (int i = n - 2; i >= 0; i--) {
            shifts[i][2] += shifts[i + 1][2];
            shifts[i][2] %= 26;
        }
        for (int i = 0; i < n; i++) {
            ch[i] = (char)(((ch[i] - 'a') + shifts[i][2]) % 26 + 'a');
        }
        return new String(ch);
    }
}