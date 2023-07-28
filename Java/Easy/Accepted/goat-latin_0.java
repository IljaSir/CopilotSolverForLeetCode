class Solution {
    public String toGoatLatin(String sentence) {
        
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char first = word.charAt(0);
            if (first == 'a' || first == 'A' || first == 'e' || first == 'E' || first == 'i' || first == 'I' || first == 'o' || first == 'O' || first == 'u' || first == 'U') {
                sb.append(word);
            } else {
                sb.append(word.substring(1, word.length()));
                sb.append(first);
            }
            sb.append("ma");
            for (int j = 0; j <= i; j++) {
                sb.append('a');
            }
            sb.append(' ');
        }
        return sb.toString().trim();
    }
}