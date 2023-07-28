class Solution {
    public int prefixCount(String[] words, String pref) {
        
        int count = 0;
        for (String word : words) {
            if (word.length() < pref.length()) {
                continue;
            }
            String prefix = word.substring(0, pref.length());
            if (prefix.equals(pref)) {
                count++;
            }
        }
        return count;
    }
}