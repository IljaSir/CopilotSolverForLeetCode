class Solution {
    public String reversePrefix(String word, char ch) {
        
        int i = word.indexOf(ch);
        if(i == -1) return word;
        return new StringBuffer(word.substring(0, i + 1)).reverse().toString() + word.substring(i + 1);
    }
}