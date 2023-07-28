class Solution {
    public String robotWithString(String s) {
        
        int n = s.length();
        char[] t = new char[n];
        int l = 0, r = n - 1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) < s.charAt(n - i - 1)) {
                t[l++] = s.charAt(i);
            } else {
                t[r--] = s.charAt(i);
            }
        }
        return new String(t);
    }
}