class Solution {
    public String strWithout3a3b(int a, int b) {
        
        char[] result = new char[a + b];
        int i = 0;
        while (a > 0 || b > 0) {
            boolean writeA = false;
            int l = i - 2;
            if (l >= 0 && result[l] == result[l + 1]) {
                if (result[l] == 'b') {
                    writeA = true;
                }
            } else {
                if (a >= b) {
                    writeA = true;
                }
            }
            if (writeA) {
                a--;
                result[i++] = 'a';
            } else {
                b--;
                result[i++] = 'b';
            }
        }
        return new String(result);
    }
}