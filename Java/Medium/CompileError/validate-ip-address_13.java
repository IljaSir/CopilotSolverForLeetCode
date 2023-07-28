class Solution {
    public String validIPAddress(String queryIP) {
        
        if(queryIPcontains(."

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
                if (Integer.pars.indexOf(c) == -1) return "Neither";
                }
            }
            return "IPv6";
        }
    }
}