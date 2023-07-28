class Solution {
    public int strStr(String haystack, String needle) {
        
        if (needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (haystack.length() - i < needle.length()) {
                    return -1;
                }
                int j = i;
                int k = 0;
                while (j < haystack.length() && k < needle.length() && haystack.charAt(j) == needle.charAt(k)) {
                    j++;
                    k++;
                }
                if (k == needle.length()) {
                    return i;
                }
            }
        }
        return -1;
    }
}