class Solution {
    public long smallestNumber(long num) {
        
        String s = String.valueOf(num);
        char[] c = s.toCharArray();
        Arrays.sort(c);
        if (c[0] == '0') {
            int i = 1;
            while (i < c.length && c[i] == '0') {
                i++;
            }
            char t = c[0];
            c[0] = c[i];
            c[i] = t;
        }
        return Long.parseLong(new String(c));
    }
}