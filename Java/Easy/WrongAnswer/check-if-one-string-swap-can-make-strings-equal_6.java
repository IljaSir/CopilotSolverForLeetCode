class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        
        boolean f = true;
        int c = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                c++;
                if (c > 2) {
                    f = false;
                    break;
                }
            }
        }
        if (c == 1) {
            f = false;
        }
        if (c == 2) {
            char[] a = s1.toCharArray();
            char[] b = s2.toCharArray();
            char t = a[0];
            a[0] = a[1];
            a[1] = t;
            if (String.valueOf(a).equals(String.valueOf(b))) {
                f = true;
            }
        }
        return f;
    }
}