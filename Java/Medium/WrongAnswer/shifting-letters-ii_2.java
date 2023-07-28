class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        
        int n = s.length();
        int[] sums = new int[n];
        sums[n-1] = shifts[n-1][2];
        for (int i = n-2; i >= 0; i--) {
            sums[i] = sums[i+1] + shifts[i][2];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int start = shifts[i][0];
            int end = shifts[i][1];
            int sum = sums[i];
            int shift = sum % 26;
            if (shifts[i][2] == 0) {
                shift = 26 - shift;
            }
            int c = s.charAt(i) - 'a';
            c = (c + shift) % 26;
            sb.append((char)(c+'a'));
        }
        return sb.toString();
    }
}