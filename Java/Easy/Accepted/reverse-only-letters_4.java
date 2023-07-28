class Solution {
    public String reverseOnlyLetters(String s) {
        
        int i = 0;
        int j = s.length() - 1;
        char[] chars = s.toCharArray();
        while (i < j) {
            if (!Character.isLetter(chars[i])) {
                i++;
                continue;
            }
            if (!Character.isLetter(chars[j])) {
                j--;
                continue;
            }
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++;
            j--;
        }
        return new String(chars);
    }
}