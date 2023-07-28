class Solution {
    public String maxValue(String n, int x) {
        
        int len = n.length();
        StringBuilder sb = new StringBuilder();
        if (n.charAt(0) == '-') {
            int i = 1;
            while (i < len && n.charAt(i) - '0' <= x) {
                sb.append(n.charAt(i));
                i++;
            }
            sb.append(x);
            while (i < len) {
                sb.append(n.charAt(i));
                i++;
            }
            return "-" + sb.toString();
        } else {
            int i = 0;
            while (i < len && n.charAt(i) - '0' >= x) {
                sb.append(n.charAt(i));
                i++;
            }
            sb.append(x);
            while (i < len) {
                sb.append(n.charAt(i));
                i++;
            }
            return sb.toString();
        }
    }
}