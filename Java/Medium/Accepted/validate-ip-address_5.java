class Solution {
    public String validIPAddress(String queryIP) {
        
        String[] ipv4 = queryIP.split("\\.", -1);
        String[] ipv6 = queryIP.split(":", -1);

        if (ipv4.length == 4) {
            for (String s : ipv4) {
                if (s.length() == 0 || s.length() > 3) {
                    return "Neither";
                }
                if (s.charAt(0) == '0' && s.length() != 1) {
                    return "Neither";
                }
                for (char c : s.toCharArray()) {
                    if (!Character.isDigit(c)) {
                        return "Neither";
                    }
                }
                if (Integer.parseInt(s) > 255) {
                    return "Neither";
                }
            }
            return "IPv4";
        } else if (ipv6.length == 8) {
            for (String s : ipv6) {
                if (s.length() == 0 || s.length() > 4) {
                    return "Neither";
                }
                for (char c : s.toCharArray()) {
                    boolean isDigit = c >= 48 && c <= 57;
                    boolean isUppercaseAF = c >= 65 && c <= 70;
                    boolean isLowerCaseAF = c >= 97 && c <= 102;
                    if (!(isDigit || isUppercaseAF || isLowerCaseAF)) {
                        return "Neither";
                    }
                }
            }
            return "IPv6";
        } else {
            return "Neither";
        }
    }
}