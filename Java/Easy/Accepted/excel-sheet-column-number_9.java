class Solution {
    public int titleToNumber(String columnTitle) {
        
        int len = columnTitle.length();
        int result = 0;
        for (int i = 0; i < len; i++) {
            result = result * 26 + columnTitle.charAt(i) - 'A' + 1;
        }
        return result;
    }
}