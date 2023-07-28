class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        int len1 = word1.length();
        int len2 = word2.length();
        int len = Math.min(len1, len2);
        char[] result = new char[len1 + len2];
        int index = 0;
        for (int i = 0; i < len; i++) {
            result[index++] = word1.charAt(i);
            result[index++] = word2.charAt(i);
        }
        if (len1 > len) {
            for (int i = len; i < len1; i++) {
                result[index++] = word1.charAt(i);
            }
        } else {
            for (int i = len; i < len2; i++) {
                result[index++] = word2.charAt(i);
            }
        }
        return new String(result);
    }
}