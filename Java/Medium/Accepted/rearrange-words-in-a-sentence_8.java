class Solution {
    public String arrangeWords(String text) {
        
        String[] words = text.split(" ");
        Arrays.sort(words, (s1, s2) -> s1.length() - s2.length());
        String result = String.join(" ", words);
        return Character.toUpperCase(result.charAt(0)) + result.substring(1).toLowerCase();
    }
}