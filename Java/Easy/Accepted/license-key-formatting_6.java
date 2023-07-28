class Solution {
    public String licenseKeyFormatting(String s, int k) {
        
        s = s.toUpperCase().replace("-", "");
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            sb.insert(0, s.charAt(i--));
            if (sb.length() % (k + 1) == k) {
                sb.insert(0, '-');
            }
        }
        if (sb.length() > 0 && sb.charAt(0) == '-') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}