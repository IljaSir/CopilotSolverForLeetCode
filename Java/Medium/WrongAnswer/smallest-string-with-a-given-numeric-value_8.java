class Solution {
    public String getSmallestString(int n, int k) {
        
        char[] s = new char[n];
        Arrays.fill(s, 'a');
        int i = n - 1;
        while (k > n) {
            s[i] = (char) ('a' + Math.min(25, k - n));
            k -= s[i] - 'a' + 1;
            i--;
        }
        s[i] = (char) ('a' + k - 1);
        return new String(s);
    }
}