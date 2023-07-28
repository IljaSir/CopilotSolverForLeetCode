class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        int l1 = word1.length();
        int l2 = word2.length();
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < l1 && j < l2) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(j));
            i++;
            j++;
        }
        if (i == l1) {
            sb.append(word2.substring(j));
        } else {
            sb.append(word1.substring(i));
        }
        return sb.toString();
    }
}