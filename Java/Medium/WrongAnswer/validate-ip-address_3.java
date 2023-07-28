class Solution {
    public String validIPAddress(String queryIP) {
        
        if (queryIP.contains(".")) {
            String[] arr = queryIP.split("\\.");
            if (arr.length != 4) {
                return "Neither";
            }
            for (String s : arr) {
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
        } else if (queryIP.contains(":")) {
            String[] arr = queryIP.split(":");
            if (arr.length != 8) {
                return "Neither";
            }
            String hex = "0123456789abcdefABCDEF";
            for (String s : arr) {
                if (s.length() == 0 || s.length() > 4) {
                    return "Neither";
                }
                for (char c : s.toCharArray()) {
                    if (hex.indexOf(c) == -1) {
                        return "Neither";
                    }
                }
            }
            return "IPv6";
        }
        return "Neither";
    }
}