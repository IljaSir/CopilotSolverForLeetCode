class Solution {
    public String robotWithString(String s) {
        
        int n = s.length();
        int l = 0, r = n - 1;
        boolean left = true;
        char[] res = new char[n];
        for (int i = 0; i < n; i++) {
            if (left) {
                if (s.charAt(l) < s.charAt(r)) {
                    res[i] = s.charAt(l++);
                } else {
                    res[i] = s.charAt(r--);
                }
            } else {
                if (s.charAt(l) > s.charAt(r)) {
                    res[i] = s.charAt(l++);
                } else {
                    res[i] = s.charAt(r--);
                }
            }
            left = !left;
        }
        return new String(res);
    }
}