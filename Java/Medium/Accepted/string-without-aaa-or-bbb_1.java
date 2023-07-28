class Solution {
    public String strWithout3a3b(int a, int b) {
        
        StringBuilder sb = new StringBuilder();
        while (a > 0 || b > 0) {
            boolean writeA = false;
            int len = sb.length();
            if (len >= 2 && sb.charAt(len - 1) == sb.charAt(len - 2)) {
                if (sb.charAt(len - 1) == 'b') {
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