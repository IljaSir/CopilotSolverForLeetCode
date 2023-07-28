class Solution {
    public boolean makeEqual(String[] words) {
        
        int[] count = new int[26];
        for (String w : words) {
            for (char c : w.toCharArray()) {
                count[c - 'a']++;
            }
        }
        for (int i : count) {
            if (i % words.length != 0) return false;
        }
        return true;
    }
}