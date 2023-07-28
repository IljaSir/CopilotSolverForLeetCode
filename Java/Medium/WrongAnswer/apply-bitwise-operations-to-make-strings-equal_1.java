class Solution {
    public boolean makeStringsEqual(String s, String target) {
        
        int ones = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones++;
            }
            if (target.charAt(i) == '1') {
                ones--;
            }
        }
        return ones == 0;
    }
}