class Solution {
    public int titleToNumber(String columnTitle) {
        
        int res = 0;
        int len = columnTitle.length();
        for (int i = 0; i < len; i++) {
            res = res * 26 + (columnTitle.charAt(i) - 'A' + 1);
        }
        return res;
    }
}