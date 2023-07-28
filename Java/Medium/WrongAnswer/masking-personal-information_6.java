class Solution {
    public String maskPII(String s) {
        
        int atIndex = s.indexOf('@');
        if (atIndex > 0) {
            return maskEmail(s.toLowerCase(), atIndex);
        } else {
            return maskPhone(s);
        }
    }

    private String maskEmail(String s, int atIndex) {
        return s.charAt(0) + "*****" + s.substring(atIndex - 1);
    }

    private String maskPhone(String s) {
        int digits = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                digits++;
            }
        }
        int local = digits - 10;
        StringBuilder sb = new StringBuilder();
        sb.append("***-***-");
        for (int i = s.length() - 4; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
        }
        if (local > 0) {
            sb.insert(0, "-");
            for (int i = 0; i < local; i++) {
                if (Character.isDigit(s.charAt(i))) {
                    sb.insert(0, s.charAt(i));
                }
            }
            sb.insert(0, "+");
            for (int i = 0; i < 3 - local; i++) {
                sb.insert(1, "*");
            }
        }
        return sb.toString();
    }
}