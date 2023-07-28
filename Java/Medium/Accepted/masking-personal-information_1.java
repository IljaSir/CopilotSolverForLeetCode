class Solution {
    public String maskPII(String s) {
        
        if (s.contains("@")) {
            return maskEmail(s);
        } else {
            return maskPhone(s);
        }
    }
    
    private String maskEmail(String s) {
        String[] parts = s.split("@");
        String name = parts[0];
        String domain = parts[1];
        return name.toLowerCase().charAt(0) + "*****" + name.toLowerCase().charAt(name.length() - 1) + "@" + domain.toLowerCase();
    }
    
    private String maskPhone(String s) {
        String digits = s.replaceAll("\\D", "");
        String last4 = digits.substring(digits.length() - 4);
        String local = "***-***-" + last4;
        if (digits.length() == 10) {
            return local;
        }
        String country = "";
        for (int i = 0; i < digits.length() - 10; i++) {
            country += "*";
        }
        return "+" + country + "-" + local;
    }
}