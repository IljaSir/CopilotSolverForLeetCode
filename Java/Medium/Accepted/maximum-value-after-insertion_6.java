class Solution {
    public String maxValue(String n, int x) {
        
        int pos = 0;
        int len = n.length();
        if (n.charAt(0) == '-') {
            while (pos < len && n.charAt(pos) - '0' <= x) {
                pos++;
            }
        } else {
            while (pos < len && n.charAt(pos) - '0' >= x) {
                pos++;
            }
        }
        return n.substring(0, pos) + x + n.substring(pos);
    }
}