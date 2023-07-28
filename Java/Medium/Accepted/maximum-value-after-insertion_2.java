class Solution {
    public String maxValue(String n, int x) {
        
        int i = 0;
        int len = n.length();
        if (n.charAt(0) == '-') {
            i = 1;
            while (i < len && n.charAt(i) - '0' <= x) {
                i++;
            }
        } else {
            while (i < len && n.charAt(i) - '0' >= x) {
                i++;
            }
        }
        return n.substring(0, i) + x + n.substring(i);
    }
}