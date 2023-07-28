class Solution {
    public String maxValue(String n, int x) {
        
        StringBuilder sb = new StringBuilder();
        if (n.charAt(0) == '-') {
            for (int i = 1; i < n.length(); i++) {
                if (n.charAt(i) - '0' > x) {
                    sb.append(n.substring(0, i));
                    sb.append(x);
                    sb.append(n.substring(i));
                    return sb.toString();
                }
            }
            sb.append(n);
            sb.append(x);
        } else {
            for (int i = 0; i < n.length(); i++) {
                if (n.charAt(i) - '0' < x) {
                    sb.append(n.substring(0, i));
                    sb.append(x);
                    sb.append(n.substring(i));
                    return sb.toString();
                }
            }
            sb.append(n);
            sb.append(x);
        }
        return sb.toString();
    }
}