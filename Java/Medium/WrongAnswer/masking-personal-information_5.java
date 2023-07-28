class Solution {
    public String maskPII(String s) {
        
        if (s.indexOf('@') != -1) {
            return maskEmail(s);
        } else {
            return maskPhone(s);
        }
    }
    
    private String maskEmail(String s) {
        String[] parts = s.toLowerCase().split("@");
        String name = parts[0];
        String domain = parts[1];
        return name.charAt(0) + "*****" + name.charAt(name.length() - 1) + "@" + domain;
    }
    
    private String maskPhone(String s) {
        String digits = s.replaceAll("\\D+", "");
        int len = digits.length();
        String local = "***-***-" + digits.substring(len - 4);
        if (len == 10) {
            return local;
        }
        String country = len == 11 ? "+" : "+*-";
        return country + local;
    }
}