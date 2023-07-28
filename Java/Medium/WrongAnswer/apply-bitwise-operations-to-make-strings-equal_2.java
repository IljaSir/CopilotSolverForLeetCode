class Solution {
    public boolean makeStringsEqual(String s, String target) {
        
        int onesS = 0;
        int onesT = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                onesS++;
            }
            if (target.charAt(i) == '1') {
                onesT++;
            }
        }
        return onesS % 2 == onesT % 2;
    }
}