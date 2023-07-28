class Solution {
    public boolean checkZeroOnes(String s) {
        
        int max1 = 0, max0 = 0, cur1 = 0, cur0 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                cur1++;
                max1 = Math.max(max1, cur1);
            } else {
                cur1 = 0;
            }
            if (s.charAt(i) == '0') {
                cur0++;
                max0 = Math.max(max0, cur0);
            } else {
                cur0 = 0;
            }
        }
        return max1 > max0;
    }
}