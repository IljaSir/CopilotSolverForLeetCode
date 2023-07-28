class Solution {
    public boolean isCircularSentence(String sentence) {
        
        String[] words = sentence.split(" ");
        char last = words[words.length-1].charAt(words[words.length-1].length()-1);
        char first = words[0].charAt(0);
        return last == first;
    }
}