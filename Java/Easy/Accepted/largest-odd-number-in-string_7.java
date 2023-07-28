class Solution {
    public String largestOddNumber(String num) {
        
        int len = num.length();
        int i = len - 1;
        while (i >= 0 && (num.charAt(i) - '0') % 2 == 0) {
            i--;
        }
        return num.substring(0, i + 1);
    }
}