class Solution {
    public String getSmallestString(int n, int k) {
        
        char[] s = new char[n];
        Arrays.fill(s, 'a');
        k -= n;
        for (int i = s.length - 1; i >= 0; i--) {
            int d = Math.min(25, k);
            s[i] = (char) (s[i] + d);
            k -= d;
        }
        return new String(s);
    }
}