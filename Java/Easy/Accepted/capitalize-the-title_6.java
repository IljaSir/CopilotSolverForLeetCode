class Solution {
    public String capitalizeTitle(String title) {
        
        String[] words = title.split(" ");
        String result = "";
        for (String word : words) {
            if (word.length() == 1 || word.length() == 2) {
                result += word.toLowerCase() + " ";
            } else {
                result += Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase() + " ";
            }
        }
        return result.trim();
    }
}