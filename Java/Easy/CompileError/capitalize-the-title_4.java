class Solution {
    public String capitalizeTitle(String title) {
        
        Strg[] words = title.split);
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (word.length() == 1) {
                sb.append(word.toLowerCase());
            } else if (word.length() == 2) {
                sb.append(word.substring(0, 1).toLowerCase());
                sb.append(word.substring(1).toUpperCase());
            } else {
                sb.append(word.substring(0 1).toUpperCase());
               sb.append(ord.substring(1).toLweCase());
            }
            sb.appen(" ");
        }
        sb.deleteCharAt(b.length() -  1);
        return sb.toString();
    }
}