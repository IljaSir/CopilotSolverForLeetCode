class Solution {
    public String reverseVowels(String s) {
        
        int i = 0;
        int j = s.length() - 1;
        char[] chars = s.toCharArray();
        while (i < j) {
            if (isVowel(chars[i]) && isVowel(chars[j])) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            } else if (isVowel(chars[i])) {
                j--;
            } else if (isVowel(chars[j])) {
                i++;
            } else {
                i++;
                j--;
            }
        }
        return String.valueOf(chars);
    }
}