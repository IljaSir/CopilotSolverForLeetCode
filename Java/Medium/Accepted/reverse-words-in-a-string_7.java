class Solution {
    public String reverseWords(String s) {
        
        int i = 0;
        int j = 0;
        String[] words = new String[10000];
        int wordCount = 0;
        while (i < s.length()) {
            while (i < s.length() && s.charAt(i) == ' ') {
                i++;
            }
            j = i;
            while (j < s.length() && s.charAt(j) != ' ') {
                j++;
            }
            if (i < s.length()) {
                words[wordCount] = s.substring(i, j);
                wordCount++;
            }
            i = j;
        }
        StringBuilder sb = new StringBuilder();
        for (int k = wordCount - 1; k >= 0; k--) {
            sb.append(words[k]);
            sb.append(' ');
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}