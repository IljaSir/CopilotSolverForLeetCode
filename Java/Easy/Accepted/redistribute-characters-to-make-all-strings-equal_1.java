class Solution {
    public boolean makeEqual(String[] words) {
        
        int[] count = new int[26];
        for (String word : words) {
            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }
        }
        for (int c : count) {
            if (c % words.length != 0) {
                return false;
            }
        }
        return true;
    }
}