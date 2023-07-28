class Solution {
    public long sumScores(String s) {
        
        int[] sum = new int[s.length()];
        sum[0] = 1;
        int[] next = new int[s.length()];
        next[0] = -1;
        int j = -1;
        for (int i = 1; i < s.length(); i++) {
            while (j > -1 && s.charAt(j + 1) != s.charAt(i)) {
                j = next[j];
            }
            if (s.charAt(j + 1) == s.charAt(i)) {
                j++;
            }
            next[i] = j;
            sum[i] = sum[j] + 1;
        }
        long res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += sum[i];
        }
        return res;
    }
}