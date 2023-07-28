class Solution {
    public String reversePrefix(String word, char ch) {
        
        int i = word.indexOf(ch);
        if (i == -1) return word;
        String prefix = word.substring(0, i + 1);
        String suffix = word.substring(i + 1);
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        sb.reverse();
        sb.append(suffix);
        return sb.toString();
    }
}