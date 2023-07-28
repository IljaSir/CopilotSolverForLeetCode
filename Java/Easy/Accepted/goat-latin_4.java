class Solution {
    public String toGoatLatin(String sentence) {
        
        String[] words = sentence.split(" ");
        String[] vowels = new String[]{"a", "e", "i", "o", "u", "A", "E", "I", "O", "U"};
        List<String> vowelList = Arrays.asList(vowels);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String first = word.substring(0, 1);
            if (vowelList.contains(first)) {
                sb.append(word);
            } else {
                sb.append(word.substring(1));
                sb.append(first);
            }
            sb.append("ma");
            for (int j = 0; j < i + 1; j++) {
                sb.append("a");
            }
            if (i != words.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}