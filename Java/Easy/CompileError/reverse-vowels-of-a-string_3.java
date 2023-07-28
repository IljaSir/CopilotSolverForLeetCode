class Solution {
    public String reverseVowels(String s) {
        
        char[] chars = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (isVowel(chars[i]) && isVowel(chars[j])) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            } else if (isVowel(chars[i]) && !isVowel(chars[j])) {
                j--;
            } else if (!isVowel(chars[i]) && isVowel(chars[j])) {
                i++;
            } else {
                i++;
                j--;
            }
        }
        return new String(chars);
    }
}