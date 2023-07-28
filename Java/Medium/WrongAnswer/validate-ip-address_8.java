class Solution {
    public String validIPAddress(String queryIP) {
        
        if (queryIP.indexOf('.') >= 0) {
            return validIPv4(queryIP);
        } else {
            return validIPv6(queryIP);
        }
    }
    
    private String validIPv4(String ip) {
        String[] parts = ip.split("\\.");
        if (parts.length != 4) return "Neither";
        for (String part : parts) {
            if (part.length() > 3) return "Neither";
            if (part.length() > 1 && part.charAt(0) == '0') return "Neither";
            int num = 0;
            for (int i = 0; i < part.length(); i++) {
                char c = part.charAt(i);
                if (c < '0' || c > '9') return "Neither";
                num = num * 10 + (c - '0');
            }
            if (num < 0 || num > 255) return "Neither";
        }
        return "IPv4";
    }
    
    private String validIPv6(String ip) {
        String[] parts = ip.split(":");
        if (parts.length != 8) return "Neither";
        for (String part : parts) {
            if (part.length() > 4 || part.length() == 0) return "Neither";
            for (int i = 0; i < part.length(); i++) {
                char c = part.charAt(i);
                if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F'))) {
                    return "Neither";
                }
            }
        }
        return "IPv6";
    }
}