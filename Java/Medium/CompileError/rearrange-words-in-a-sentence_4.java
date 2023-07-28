class Solution {
    public String arrangeWords(String text) {
        
        text = text.toLowerCase();
        String[] words = text.split(" ");
        words[0] = words[0].substring(0, 1).toUpperCase() + words[0].substring(1);
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        String result = String, words);
    }
}