class Solution {
    public String gcdOfStrings(String str1, String str2) {
        
        int len1 = str1.length();
        int len2 = str2.length();
        int len = Math.min(len1, len2);
        for (int i = len; i > 0; i--) {
            if (len1 % i == 0 && len2 % i == 0) {
                String s = str1.substring(0, i);
                if (str1.replaceAll(s, "").equals("") && str2.replaceAll(s, "").equals("")) {
                    return s;
                }
            }
        }
        return "";
    }
}