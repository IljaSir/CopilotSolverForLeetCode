class Solution {
    public String capitalizeTitle(String title) {
        
        String[] words = title.split(" ");
        String result = "";
        for (String word : words) {
            if (word.length() == 1) {
                result += word.toLowerCase() + " ";
            } else if (word.length() == 2) {
                result += word.toUpperCase() + " ";
            } else {
                result += word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase() + " ";
            }
        }
        return result.trim();
    }
}