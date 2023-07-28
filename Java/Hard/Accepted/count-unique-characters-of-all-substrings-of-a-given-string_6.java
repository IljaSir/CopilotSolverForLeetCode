class Solution {
    public int uniqueLetterString(String s) {
        
        int mod = 1000000007;
        int n = s.length();
        int[] last = new int[26];
        Arrays.fill(last, -1);
        int[] prev = new int[n];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            prev[i] = last[c - 'A'];
            last[c - 'A'] = i;
        }
        Arrays.fill(last, n);
        int[] next = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            next[i] = last[c - 'A'];
            last[c - 'A'] = i;
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            res = (res + (i - prev[i]) * (next[i] - i)) % mod;
        }
        return (int) res;
    }
}