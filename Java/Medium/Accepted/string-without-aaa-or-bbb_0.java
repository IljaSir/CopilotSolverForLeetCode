class Solution {
    public String strWithout3a3b(int a, int b) {
        
        StringBuilder sb = new StringBuilder();
        while (a > 0 || b > 0) {
            boolean writeA = false;
            int l = sb.length();
            if (l >= 2 && sb.charAt(l - 1) == sb.charAt(l - 2)) {
                if (sb.charAt(l - 1) == 'b') {
                    writeA = true;
                }
            } else {
                if (a >= b) {
                    writeA = true;
                }
            }
            if (writeA) {
                a--;
                sb.append('a');
            } else {
                b--;
                sb.append('b');
            }
        }
        return sb.toString();
    }
}