class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (String root: dictionary) {
                if (word.startsWith(root)) {
                    words[i] = root;
                    break;
                }
            }
        }
        return String.join(" ", words);
    }
}