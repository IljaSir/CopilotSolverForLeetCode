class Solution {
    public String maskPII(String s) {
        
        if (s.contains("@")) {
            return maskEmail(s);
        } else {
            return maskPhone(s);
        }
    }
    
    private String maskPhone(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        String digits = sb.toString();
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