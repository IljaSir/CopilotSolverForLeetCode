class Solution {
    public String capitalizeTitle(String title) {
        
        String[] words = title.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() <= 2) {
                sb.append(words[i].toLowerCase());
            } else {
                sb.append(words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase());
            }
            if (i != words.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}