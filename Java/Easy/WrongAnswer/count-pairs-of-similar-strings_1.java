class Solution {
    public int similarPairs(String[] words) {
        
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isSimilar(words[i], words[j])) {
                    count++;
                }
            }
        }
        return count;
    }
    
    private boolean isSimilar(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int[] map = new int[26];
        for (int i = 0; i < a.length(); i++) {
            map[a.charAt(i) - 'a']++;
            map[b.charAt(i) - 'a']--;
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0) {
                return false;
            }
        }
        return true;
    }
}