class Solution {
    public String arrangeWords(String text) {
        
        String[] words = text.toLowerCase().split(" ");
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        words[0] = words[0].substring(0, 1).toUpperCase() + words[0].substring(1);
        return String.join(" ", words);
    }
}