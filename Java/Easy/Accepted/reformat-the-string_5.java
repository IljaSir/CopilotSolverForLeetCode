class Solution {
    public String reformat(String s) {
        
        int n = s.length();
        String alpha = "";
        String num = "";
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num += s.charAt(i);
            } else {
                alpha += s.charAt(i);
            }
        }
        if (Math.abs(alpha.length() - num.length()) > 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (alpha.length() > num.length()) {
            for (int i = 0; i < num.length(); i++) {
                sb.append(alpha.charAt(i));
                sb.append(num.charAt(i));
            }
            sb.append(alpha.charAt(alpha.length() - 1));
        } else {
            for (int i = 0; i < alpha.length(); i++) {
                sb.append(num.charAt(i));
                sb.append(alpha.charAt(i));
            }
            if (num.length() > alpha.length()) {
                sb.append(num.charAt(num.length() - 1));
            }
        }
        return sb.toString();
    }
}