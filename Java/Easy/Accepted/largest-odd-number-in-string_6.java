class Solution {
    public String largestOddNumber(String num) {
        
        int i = 0;
        for (i = num.length() - 1; i >= 0; i--) {
            if ((num.charAt(i) - '0') % 2 != 0) {
                break;
            }
        }
        return num.substring(0, i + 1);
    }
}