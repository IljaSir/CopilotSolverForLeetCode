class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        
        String[] morse = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        String[] encoded = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                sb.append(morse[c - 'a']);
            }
            encoded[i] = sb.toString();
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i < encoded.length; i++) {
            set.add(encoded[i]);
        }
        return set.size();
    }
}