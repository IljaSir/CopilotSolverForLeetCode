class Solution {
    public String maskPII(String s) {
        
        if (s.indexOf('@') > 0) {
            s = s.toLowerCase();
            int i = s.indexOf('@');
            return (s.charAt(0) + "*****" + s.substring(i-1)).toLowerCase();
        } else {
            s = s.replaceAll("\\D+", "");
            String local = "***-***-" + s.substring(s.length() - 4);
            if (s.length() == 10) return local;
            String ans = "+";
            for (int i = 0; i < s.length() - 10; ++i)
                ans += "*";
            return ans + "-" + local;
        }
    }
}