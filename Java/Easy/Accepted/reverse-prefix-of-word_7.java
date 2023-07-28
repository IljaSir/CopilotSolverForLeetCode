class Solution {
    public String reversePrefix(String word, char ch) {
        
        int idx = word.indexOf(ch);
        if (idx >= 0) {
            String prefix = word.substring(0, idx + 1);
            String suffix = word.substring(idx + 1);
            StringBuilder sb = new StringBuilder(prefix);
            sb.reverse();
            return sb.toString() + suffix;
        } else {
            return word;
        }
    }
}