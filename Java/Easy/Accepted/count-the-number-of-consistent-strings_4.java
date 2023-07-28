class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        
        int[] a = new int[26];
        for (int i = 0; i < allowed.length(); i++) {
            a[allowed.charAt(i) - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            int j = 0;
            for (; j < words[i].length(); j++) {
                if (a[words[i].charAt(j) - 'a'] == 0) {
                    break;
                }
            }
            if (j == words[i].length()) {
                count++;
            }
        }
        return count;
    }
}