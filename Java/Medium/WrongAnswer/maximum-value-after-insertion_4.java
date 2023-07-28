class Solution {
    public String maxValue(String n, int x) {
        
        boolean isNegative = false;
        if (n.charAt(0) == '-') {
            isNegative = true;
        }
        StringBuilder sb = new StringBuilder();
        if (isNegative) {
            sb.append('-');
        }
        int i = 0;
        if (isNegative) {
            i = 1;
        }
        for (; i < n.length(); i++) {
            if (isNegative) {
                if (n.charAt(i) - '0' > x) {
                    sb.append(x);
                    break;
                }
            } else {
                if (n.charAt(i) - '0' < x) {
                    sb.append(x);
                    break;
                }
            }
            sb.append(n.charAt(i));
        }
        if (i == n.length()) {
            sb.append(x);
        }
        return sb.toString();
    }
}