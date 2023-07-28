class Solution {
    public String reversePrefix(String word, char ch) {
        
        int index = word.indexOf(ch);
        if(index != -1){
            StringBuilder sb = new StringBuilder(word);
            sb.reverse();
            String reverse = sb.toString();
            return reverse.substring(0, word.length() - index) + word.substring(word.length() - index);
        }
        return word;
    }
}