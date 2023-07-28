class Solution {
    public String reversePrefix(String word, char ch) {
        
        int i = word.indexOf(ch);
        if (i == -1) {
            return word;
        }
        String s1 = word.substring(0, i+1);
        String s2 = word.substring(i+1);
        StringBuilder sb = new StringBuilder(s1);
        sb.reverse();
        return sb.toString() + s2;
    }
}