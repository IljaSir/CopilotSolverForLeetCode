class Solution {
    public String capitalizeTitle(String title) {
        
        String[] words = title.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == 1 || words[i].length() == 2) {
                sb.append(words[i].toLowerCase());
            } else {
                sb.append(words[i].substring(01).toUpperCase());
                sb.append(s[i].substring(1).toLowerCae()
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}