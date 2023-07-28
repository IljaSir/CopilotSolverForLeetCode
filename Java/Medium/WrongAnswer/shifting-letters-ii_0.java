class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        
        int n = s.length();
        int[] sum = new int[n];
        sum[n - 1] = shifts[n - 1][2];
        for (int i = n - 2; i >= 0; i--) {
            sum[i] = sum[i + 1] + shifts[i][2];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int offset = sum[i] % 26;
            char c = s.charAt(i);
            for (int j = 0; j < offset; j++) {
                if (c == 'z') {
                    c = 'a';
                } else {
                    c++;
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
}