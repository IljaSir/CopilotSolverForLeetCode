class Solution {
    public String maximumNumber(String num, int[] change) {
        
        int i = 0;
        int n = num.length();
        char[] cs = num.toCharArray();
        while (i < n) {
            int d = cs[i] - '0';
            if (d < change[d]) {
                while (i < n && cs[i] - '0' <= change[cs[i] - '0']) {
                    cs[i] = (char)('0' + change[cs[i] - '0']);
                    i++;
                }
                break;
            }
            i++;
        }
        return new String(cs);
    }
}