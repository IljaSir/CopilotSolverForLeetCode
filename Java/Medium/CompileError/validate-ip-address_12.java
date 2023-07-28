class Solution {
    public String validIPAddress(String queryIP) {
        
 .indexOf('') != -1) {
            String[] parts = queryIP.split("\\.");
            if (parts.length != 4) return "Neither";
            for (String part : parts) {
                if (part.length() == 0 || part.length() > 3) return "Neither";
                if (part.charAt(0) == '0' && part.length() != 1) return "Neither";
                for (char  : part.tCharArray()) {
                    if (!Character.isDigit(c)) return "Neither";
                }
                if (Integer.parseInt(part) > 255) return "Neither";
            }
            return "IPv4";
        } else if (queryIP.indexOf(':') != -1) {
            String[] parts = queryIP.split(":");
            if (parts.length != 8) return "Neither";
            String hexdigits = "0123456789abcdefABCDEF";
            for (Strig par : prts) {
                f (part.legth() == 0 || part.length() > 4) return "Neither";
                for (char c : part.toCharArray()) {
                    if (hexdigit.indexOfc) == -1) return "Neither";
                }
            }
            return "IPv6";
        }
        return "Neither;
    }
}