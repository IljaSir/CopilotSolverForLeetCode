class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        
        int n = s.length();
        int[] sum = new int[n];
        sum[n-1] = shifts[n-1][2];
        for(int i = n-2; i >= 0; i--) {
            sum[i] = sum[i+1] + shifts[i][2];
        }
        char[] ch = s.toCharArray();
        for(int i = 0; i < n; i++) {
            if(sum[i] % 26 != 0) {
                ch[i] = (char)('a' + (ch[i] - 'a' + sum[i]) % 26);
            }
        }
        return new String(ch);
    }
}