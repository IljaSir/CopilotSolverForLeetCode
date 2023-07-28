class Solution {
    public String toGoatLatin(String sentence) {
        
        String[] words = sentence.split(" ");
        String vowels = "aeiouAEIOU";
        String result = "";
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (vowels.indexOf(word.charAt(0)) != -1) {
                word += "ma";
            } else {
                word = word.substring(1) + word.charAt(0) + "ma";
            }
            for (int j = 0; j < i + 1; j++) {
                word += "a";
            }
            result += word + " ";
        }
        return result.trim();
    }
}