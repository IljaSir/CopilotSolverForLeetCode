class Solution {
    public String capitalizeTitle(String title) {
        
        String[] words = title.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() <= 2) {
                words[i] = word.toLowerCase();
            } else {
                words[i] = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
            }
        }
        return String.join(" ", words);
    }
}