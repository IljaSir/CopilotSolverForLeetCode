class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            for (String root : dictionary) {
                if (words[i].startsWith(root)) {
                    words[i] = root;
                }
            }
        }
        return String.join(" ", words);
    }
}