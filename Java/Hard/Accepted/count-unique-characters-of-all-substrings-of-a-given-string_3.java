class Solution {
    public int uniqueLetterString(String s) {
        
        int[] last = new int[26];
        int[] prev = new int[26];
        Arrays.fill(last, -1);
        Arrays.fill(prev, -1);
        int res = 0, n = s.length();
        for (int i = 0; i < n; ++i) {
            int c = s.charAt(i) - 'A';
            res += (i - last[c]) * (last[c] - prev[c]);
            prev[c] = last[c];
            last[c] = i;
        }
        for (int c = 0; c < 26; ++c)
            res += (n - last[c]) * (last[c] - prev[c]);
        return res;
    }
}