class Solution {
    public String robotWithString(String s) {
        
        int n = s.length();
        char[] t = new char[n];
        int l = 0, r = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(l) < s.charAt(r)) {
                t[i] = s.charAt(l++);
            } else if (s.charAt(l) > s.charAt(r)) {
                t[i] = s.charAt(r--);
            } else {
                int j = 1;
                while (l + j <= r && s.charAt(l + j) == s.charAt(r - j)) {
                    j++;
                }
                if (l + j > r || s.charAt(l + j) < s.charAt(r - j)) {
                    t[i] = s.charAt(l++);
                } else {
                    t[i] = s.charAt(r--);
                }
            }
        }
        return new String(t);
    }
}