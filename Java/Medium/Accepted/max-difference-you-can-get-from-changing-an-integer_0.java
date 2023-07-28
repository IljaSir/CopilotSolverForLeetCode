class Solution {
    public int maxDiff(int num) {
        
        String s = String.valueOf(num);
        char[] a = s.toCharArray();
        char[] b = s.toCharArray();
        char x = 'a';
        char y = 'b';
        for (int i = 0; i < a.length; i++) {
            if (a[i] != '9') {
                x = a[i];
                break;
            }
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) {
                a[i] = '9';
            }
        }
        if (b[0] != '1') {
            y = b[0];
            for (int i = 0; i < b.length; i++) {
                if (b[i] == y) {
                    b[i] = '1';
                }
            }
        } else {
            for (int i = 1; i < b.length; i++) {
                if (b[i] != '0' && b[i] != '1') {
                    y = b[i];
                    break;
                }
            }
            for (int i = 0; i < b.length; i++) {
                if (b[i] == y) {
                    b[i] = '0';
                }
            }
        }
        return Integer.valueOf(String.valueOf(a)) - Integer.valueOf(String.valueOf(b));
    }
}