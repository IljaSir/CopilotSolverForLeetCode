class Solution {
    public int maxDiff(int num) {
        
        String s = Integer.toString(num);
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int x = 0;
        int y = 0;
        int z = 0;
        int w = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                if (s.charAt(i) == '1') {
                    x = 1;
                    y = 9;
                } else {
                    x = 9;
                    y = 1;
                }
                if (s.charAt(i) == '0') {
                    z = 1;
                    w = 0;
                } else {
                    z = 0;
                    w = 1;
                }
            }
            if (s.charAt(i) == '1') {
                a = a * 10 + x;
                b = b * 10 + y;
            } else {
                a = a * 10 + s.charAt(i) - '0';
                b = b * 10 + s.charAt(i) - '0';
            }
            if (s.charAt(i) == '0') {
                c = c * 10 + z;
                d = d * 10 + w;
            } else {
                c = c * 10 + s.charAt(i) - '0';
                d = d * 10 + s.charAt(i) - '0';
            }
        }
        return Math.max(a - c, b - d);
    }
}