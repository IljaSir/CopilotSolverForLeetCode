class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        
        Set<Character> brokenLettersSet = new HashSet<>();
        for (char c : brokenLetters.toCharArray()) {
            brokenLettersSet.add(c);
        }
        int count = 0;
        String[] words = text.split(" ");
        for (String word : words) {
            boolean broken = false;
            for (char c : word.toCharArray()) {
                if (brokenLettersSet.contains(c)) {
                    t;
    }
}