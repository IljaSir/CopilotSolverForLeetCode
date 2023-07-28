class Solution {
    public String maskPII(String s) {
        
        if (s.contains("@")) {
            String[] parts = s.split("@");
            String name = parts[0].toLowerCase();
            String domain = parts[1].toLowerCase();
            return name.charAt(0) + "*****" + name.charAt(name.length() - 1) + "@" + domain;
        } else {
            String digits = s.replaceAll("\\D", "");
            String local = "***-***-" + digits.substring(digits.length() - 4);
            if (digits.length() == 10) {
                return local;
            }
            String ans = "+";
            for (int i = 0; i < digits.length() - 10; ++i) {
                ans += "*";
            }
            return ans + "-" + local;
        }
    }
}