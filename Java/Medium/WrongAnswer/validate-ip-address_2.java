class Solution {
    public String validIPAddress(String queryIP) {
        
        if (queryIP.contains(".")) {
            String[] parts = queryIP.split("\\.");
            if (parts.length != 4) {
                return "Neither";
            }
            for (String part: parts) {
                if (part.length() == 0 || part.length() > 3) {
                    return "Neither";
                }
                if (part.charAt(0) == '0' && part.length() != 1) {
                    return "Neither";
                }
                for (char c: part.toCharArray()) {
                    if (!Character.isDigit(c)) {
                        return "Neither";
                    }
                }
                if (Integer.parseInt(part) > 255) {
                    return "Neither";
                }
            }
            return "IPv4";
        } else {
            String[] parts = queryIP.split(":");
            if (parts.length != 8) {
                return "Neither";
            }
            String hexdigits = "0123456789abcdefABCDEF";
            for (String part: parts) {
                if (part.length() == 0 || part.length() > 4) {
                    return "Neither";
                }
                for (char c: part.toCharArray()) {
                    if (hexdigits.indexOf(c) == -1) {
                        return "Neither";
                    }
                }
            }
            return "IPv6";
        }
    }
}