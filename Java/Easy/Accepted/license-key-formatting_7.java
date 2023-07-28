class Solution {
    public String licenseKeyFormatting(String s, int k) {
        
        String str = s.replaceAll("-", "");
        StringBuilder sb = new StringBuilder();
        int i = str.length() - 1;
        int count = 0;
        while (i >= 0) {
            sb.append(str.charAt(i));
            count++;
            if (count == k && i != 0) {
                sb.append("-");
                count = 0;
            }
            i--;
        }
        return sb.reverse().toString().toUpperCase();
    }
}