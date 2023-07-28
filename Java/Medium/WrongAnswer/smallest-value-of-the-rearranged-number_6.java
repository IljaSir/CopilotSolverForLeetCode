class Solution {
    public long smallestNumber(long num) {
        
        String s = String.valueOf(num);
        char[] c = s.toCharArray();
        Arrays.sort(c);
        if (c[0] == '0') {
            int i;
            for (i = 1; i < c.length; i++) {
                if (c[i] != '0') {
                    char temp = c[0];
                    c[0] = c[i];
                    c[i] = temp;
                    break;
                }
            }
            if (i == c.length) {
                return 0;
            }
        }
        return Long.parseLong(new String(c));
    }
}