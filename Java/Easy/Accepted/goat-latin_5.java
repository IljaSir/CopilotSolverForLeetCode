class Solution {
    public String toGoatLatin(String sentence) {
        
        String[] words = sentence.split(" ");
        String[] vowels = new String[]{"a", "e", "i", "o", "u", "A", "E", "I", "O", "U"};
        List<String> vowelList = Arrays.asList(vowels);
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (String word : words) {
            if (vowelList.contains(word.substring(0, 1))) {
                sb.append(word);
                sb.append("ma");
            } else {
                sb.append(word.substring(1));
                sb.append(word.substring(0, 1));
                sb.append("ma");
            }
            for (int i = 0; i < count; i++) {
                sb.append("a");
            }
            sb.append(" ");
            count++;
        }
        return sb.toString().trim();
    }
}