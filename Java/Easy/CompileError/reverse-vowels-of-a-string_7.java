class Solution {
    public String reverseVowels(String s) {
        
        char[] c = s.toCharArray();
        int i = 0, j = c.length - 1;
        while (i < j) {
            if (!isVowel(c[i])) {
                i++;
            } else if (!isVowel(c[j])) {
                j--;
            } else {
                char tmp = c[i];
                c[i] = c[j];
                c[j] = tmp;
                i++;
                j--;
            }
        }
        return String.valueOf(c);
    }
}