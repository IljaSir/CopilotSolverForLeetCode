class Solution {
    public String gcdOfStrings(String str1, String str2) {
        
        String s = str1.length() > str2.length() ? str1 : str2;
        String t = str1.length() > str2.length() ? str2 : str1;

        int i = 0;
        while (i < t.length() && s.charAt(i) == t.charAt(i)) {
            i++;
        }

        if (i == 0) {
            return "";
        }

        String d = t.substring(0, i);
        for (int j = 0; j < s.length(); j += d.length()) {
            if (!s.substring(j, j + d.length()).equals(d)) {
                return "";
            }
        }

        return d;
    }
}