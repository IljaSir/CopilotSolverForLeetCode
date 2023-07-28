class Solution {
    public String toGoatLatin(String sentence) {
        
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char c = word.charAt(0);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                sb.append(word);
            } else {
                sb.append(word.substring(1));
                sb.append(word.charAt(0));
            }
            sb.append("ma");
            for (int j = 0; j < i + 1; j++) {
                sb.append("a");
            }
            sb.append(" ");
        }

        return sb.toString().trim();
    }
}