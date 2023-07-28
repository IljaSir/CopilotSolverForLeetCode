class Solution {
    public int minimumLengthEncoding(String[] words) {
        
        int result = 0;
        Set<String> s = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                s.remove(word.substring(i));
            }
        }
        for (String word : s) {
            result += word.length() + 1;
        }
        return result;
    }
}