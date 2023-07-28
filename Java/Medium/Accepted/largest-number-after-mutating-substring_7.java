class Solution {
    public String maximumNumber(String num, int[] change) {
        
        char[] c = num.toCharArray();
        int n = c.length;
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            int x = c[i] - '0';
            if (change[x] > x) {
                c[i] = (char) (change[x] + '0');
                changed = true;
            } else if (change[x] < x && changed) {
                break;
            }
        }
        return String.valueOf(c);
    }
}