class Solution {
    public String licenseKeyFormatting(String s, int k) {
        
        int n = s.length();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '-') {
                continue;
            }
            if (count == k) {
                sb.append('-');
                count = 0;
            }
            sb.append(Character.toUpperCase(s.charAt(i)));
            count++;
        }
        return sb.reverse().toString();
    }
}