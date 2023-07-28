class Solution {
    public String reverseVowels(String s) {
        
        char[] chars = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char c1 = chars[i];
            char c2 = chars[j];
            if (isVowel(c1) && isVowel(c2)) {
                chars[i] = c2;
                chars[j] = c1;
                i++;
                j--;
            } else if (isVowel(c1)) {
                j--;
            } else if (isVowel(c2)) {
                i++;
            } else {
                i++;
                j--;
            }
        }
        return new String(chars);
    }
}