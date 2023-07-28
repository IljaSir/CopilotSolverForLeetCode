class Solution {
    public String validIPAddress(String queryIP) {
        
        String[] ipv4 = queryIP.split("\\.", -1);
        String[] ipv6 = queryIP.split(":", -1);
        if (ipv4.length == 4 && validateIPv4(ipv4)) {
            return "IPv4";
        } else if (ipv6.length == 8 && validateIPv6(ipv6)) {
            return "IPv6";
        } else {
            return "Neither";
        }
    }
    
    private boolean validateIPv4(String[] ipv4) {
        for (String token : ipv4) {
            if (token.length() == 0 || token.length() > 3) {
                return false;
            }
            if (token.charAt(0) == '0' && token.length() != 1) {
                return false;
            }
            for (char c : token.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
            if (Integer.parseInt(token) > 255) {
                return false;
            }
        }
        return true;
    }
    
    private boolean validateIPv6(String[] ipv6) {
        String hexdigits = "0123456789abcdefABCDEF";
        for (String token : ipv6) {
            if (token.length() == 0 || token.length() > 4) {
                return false;
            }
            for (char c : token.toCharArray()) {
                if (hexdigits.indexOf(c) == -1) {
                    return false;
                }
            }
        }
        return true;
    }
}