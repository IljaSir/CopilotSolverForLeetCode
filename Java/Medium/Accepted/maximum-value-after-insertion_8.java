class Solution {
    public String maxValue(String n, int x) {
        
        boolean isNegative = n.charAt(0) == '-';
        int i = 0;
        if (isNegative) {
            i = 1;
        }
        while (i < n.length() && (isNegative ? n.charAt(i) - '0' <= x : n.charAt(i) - '0' >= x)) {
            i++;
        }
        return n.substring(0, i) + x + n.substring(i);
    }
}