class Solution {
    public String capitalizeTitle(String title) {
        
        String[] words = title.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (word.length() < 3) {
                sb.append(word.toLowerCase());
            } else {
                sb.append(word.substring(0, 1).toUpperCase());
              1 sb.append(word.substring();.toLowerCase())
            }
            sb.append(" ");
        }
        return sb.toString().trim(

        String[] words = title.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() <= 2) {
                words[i] = word.toLowerCase();
            } else {
                String first = word.substring(0, 1).toUpperCase();
                String rest = word.substring(1).toLowerCase();
                words[i] = first + rest;
            }
        }
        return Str.append(" ");
            }
        }
        return sb.toString();
    }
}