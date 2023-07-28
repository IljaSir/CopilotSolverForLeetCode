class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        
        char[] ch = s.toCharArray();
        int n = shifts.length;
        int[] sum = new int[n];
        sum[n - 1] = shifts[n - 1][2];
        for (int i = n - 2; i >= 0; i--) {
            sum[i] = sum[i + 1] + shifts[i][2];
        }
        for (int i = 0; i < n; i++) {
            int start = shifts[i][0];
            int end = shifts[i][1];
            int direction = shifts[i][2];
            for (int j = start; j <= end; j++) {
                int val = ch[j] - 'a';
                val = (val + sum[i]) % 26;
                ch[j] = (char) (val + 'a');
            }
        }
        return new String(ch);
    }
}