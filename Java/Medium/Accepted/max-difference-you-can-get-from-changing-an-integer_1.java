class Solution {
    public int maxDiff(int num) {
        
        String s = String.valueOf(num);
        char[] c = s.toCharArray();
        int n = c.length;
        int a = num;
        int b = num;
        for (int i = 0; i < n; i++) {
            if (c[i] != '9') {
                a = Math.max(a, Integer.parseInt(s.replace(c[i], '9')));
                break;
            }
        }
        if (c[0] != '1') {
            b = Math.min(b, Integer.parseInt(s.replace(c[0], '1')));
        } else {
            for (int i = 1; i < n; i++) {
                if (c[i] != '0' && c[i] != '1') {
                    b = Math.min(b, Integer.parseInt(s.replace(c[i], '0')));
                    break;
                }
            }
        }
        return a - b;
    }
}