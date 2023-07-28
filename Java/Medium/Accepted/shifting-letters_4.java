class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        
        int n = s.length();
        long[] sum = new long[n];
        sum[n-1] = shifts[n-1];
        for (int i = n-2; i >= 0; i--) {
            sum[i] = sum[i+1] + shifts[i];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            c = (int)((c + sum[i]) % 26);
            sb.append((char)('a' + c));
        }
        return sb.toString();
    }
}