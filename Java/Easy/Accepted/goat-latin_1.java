class Solution {
    public String toGoatLatin(String sentence) {
        
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char first = word.charAt(0);
            if (first == 'a' || first == 'e' || first == 'i' || first == 'o' || first == 'u'
                    || first == 'A' || first == 'E' || first == 'I' || first == 'O' || first == 'U') {
                sb.append(word);
            } else {
                sb.append(word.substring(1)).append(first);
            }
            sb.append("ma");
            for (int j = 0; j <= i; j++) {
                sb.append("a");
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}