class Solution {
    public int minimumLengthEncoding(String[] words) {
        
        HashSet<String> set = new HashSet<String>();
        for (String word: words) {
            set.add(word);
        }
        
        for (String word: words) {
            for (int i=1; i<word.length(); i++) {
                set.remove(word.substring(i));
            }
        }
        
        int result = 0;
        for (String word: set) {
            result += word.length() + 1;
        }
        
        return result;
    }
}