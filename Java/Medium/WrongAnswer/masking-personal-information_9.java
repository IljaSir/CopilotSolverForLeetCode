class Solution {
    public String maskPII(String s) {
        
        String[] email = s.split("@");
        if (s.contains("@")){
            return (email[0].charAt(0) + "*****" + email[0].charAt(email[0].length() - 1) + "@" + email[1].toLowerCase());
        }
        String digits = s.replaceAll("\\D+","");
        String local = "***-***-" + digits.substring(digits.length() - 4);
        if (digits.length() == 10) return local;
        String ans = "+";
        for (int i = 0; i < digits.length() - 10; ++i)
            ans += "*";
        return ans + "-" + local;
    }
}