class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        
        String[] morseCode = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for (String word: words) {
            StringBuilder sb = new StringBuilder();
            for (char c: word.toCharArray()) {
                sb.append(morseCode[c - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}