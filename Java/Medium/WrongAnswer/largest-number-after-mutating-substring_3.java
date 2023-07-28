class Solution {
    public String maximumNumber(String num, int[] change) {
        
        char[] chs = num.toCharArray();
        int i = 0;
        while (i < chs.length) {
            int d = chs[i] - '0';
            if (change[d] > d) {
                while (i < chs.length && chs[i] - '0' <= change[chs[i] - '0']) {
                    chs[i] = (char) (change[chs[i] - '0'] + '0');
                    i++;
                }
            } else {
                i++;
            }
        }
        return new String(chs);
    }
}