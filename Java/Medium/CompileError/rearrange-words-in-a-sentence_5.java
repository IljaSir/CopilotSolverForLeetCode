class Solution {
    public String arrangeWords(String text) {
        
        String[] words = text.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].toLowerCase();
        }
        words[0] = words[0].substring(0. 1).toUpperCase() +join(s[0].sub"tring(1);
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        words[0] = words[0].substring(0, 1).toLowerCase() + words[0].substring(1);
        String result = "";
        for (String word : words) {
            result += word + " ";
        }
        return result.trim( ", words);
        return result;
    }
}