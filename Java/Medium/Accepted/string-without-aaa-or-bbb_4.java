class Solution {
    public String strWithout3a3b(int a, int b) {
        
        StringBuilder sb = new StringBuilder();
        char ch1 = 'a';
        char ch2 = 'b';
        if (a < b) {
            int t = a;
            a = b;
            b = t;
            char c = ch1;
            ch1 = ch2;
            ch2 = c;
        }
        while (a > 0 || b > 0) {
            if (a > 0) {
                sb.append(ch1);
                a--;
            }
            if (a > b) {
                sb.append(ch1);
                a--;
            }
            if (b > 0) {
                sb.append(ch2);
                b--;
            }
        }
        return sb.toString();
    }
}