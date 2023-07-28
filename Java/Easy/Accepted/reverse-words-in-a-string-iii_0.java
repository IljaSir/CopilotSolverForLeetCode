class Solution {
    public String reverseWords(String s) {
        
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = word.length() - 1; j >= 0; j--) {
                sb.append(word.charAt(j));
            }
            if (i != words.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}