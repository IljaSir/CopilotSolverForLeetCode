class Solution {
    public int strStr(String haystack, String needle) {
        
        if (needle == null || haystack == null)
            return -1;
        if (needle.length() == 0)
            return 0;
        int i = 0;
        int j = 0;
        int[] next = new int[needle.length()];
        next[0] = -1;
        for (int k = 1; k < needle.length(); k++) {
            if (needle.charAt(k) == needle.charAt(j)) {
                next[k] = next[j];
            } else {
                next[k] = j;
                while (j != -1 && needle.charAt(k) != needle.charAt(j)) {
                    j = next[j];
                }
            }
            j++;
        }
        i = 0;
        j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else if (j == 0) {
                i++;
            } else {
                j = next[j];
            }
        }
        if (j == needle.length()) {
            return i - j;
        } else {
            return -1;
        }
    }
}