class Solution {
    public String toGoatLatin(String sentence) {
        
        String[] words = sentence.split(" ");
        String[] result = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            result[i] = convertToGoatLatin(words[i], i + 1);
        }
        return String.join(" ", result);
    }

    private String convertToGoatLatin(String word, int index) {
        if (word.startsWith("a") || word.startsWith("e") || word.startsWith("i") || word.startsWith("o") || word.startsWith("u") || word.startsWith("A") || word.startsWith("E") || word.startsWith("I") || word.startsWith("O") || word.startsWith("U")) {
            word += "ma";
        } else {
            word = word.substring(1) + word.charAt(0) + "ma";
        }
        for (int i = 0; i < index; i++) {
            word += "a";
        }
        return word;
    }
}