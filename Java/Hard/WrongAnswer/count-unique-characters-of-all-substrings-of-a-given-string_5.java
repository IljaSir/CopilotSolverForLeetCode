class Solution {
    public int uniqueLetterString(String s) {
        
        int ans = 0;
        int n = s.length();
        int[] last = new int[26];
        int[] next = new int[26];
        Arrays.fill(last, -1);
        Arrays.fill(next, n);
        for (int i = n - 1; i >= 0; i--) {
            int c = s.charAt(i) - 'A';
            next[c] = i;
        }
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'A';
            ans += (i - last[c]) * (next[c] - i);
            last[c] = i;
        }
        return ans;
    }
}