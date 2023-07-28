class Solution {
    public String maxValue(String n, int x) {
        
        boolean neg = n.charAt(0) == '-';
        int i = neg ? 1 : 0;
        for (; i < n.length(); i++) {
            if (neg && n.charAt(i) - '0' <= x) {
                break;
            } else if (!neg && n.charAt(i) - '0' >= x) {
                break;
            }
        }
        return n.substring(0, i) + x + n.substring(i);
    }
}