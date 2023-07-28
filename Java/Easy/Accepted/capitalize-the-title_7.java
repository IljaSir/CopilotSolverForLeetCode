class Solution {
    public String capitalizeTitle(String title) {
        
        String[] words = title.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (word.length() > 2) {
                sb.append(word.substring(0, 1).toUpperCase());
                sb.append(word.substring(1).toLowerCase());
            } else {
                sb.append(word.toLowerCase());
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}