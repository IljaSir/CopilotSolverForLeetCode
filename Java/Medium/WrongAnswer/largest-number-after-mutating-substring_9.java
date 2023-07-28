class Solution {
    public String maximumNumber(String num, int[] change) {
        
        int len = num.length();
        char[] ca = num.toCharArray();
        int i = 0;
        while (i < len) {
            int n = num.charAt(i) - '0';
            if (change[n] > n) {
                while (i < len && num.charAt(i) - '0' <= change[num.charAt(i) - '0']) {
                    ca[i] = (char) (change[num.charAt(i) - '0'] + '0');
                    i++;
                }
            } else if (change[n] < n) {
                break;
            } else {
                i++;
            }
        }
        return new String(ca);
    }
}