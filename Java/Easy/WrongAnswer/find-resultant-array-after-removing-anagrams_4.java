class Solution {
    public List<String> removeAnagrams(String[] words) {
        
        List<String> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return result;
        }
        int n = words.length;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            result.add(words[i]);
            for (int j = i + 1; j < n; j++) {
                if (visited[j]) {
                    continue;
                }
                if (isAnagram(words[i], words[j])) {
                    visited[j] = true;
                }
            }
        }
        return result;
    }
    
    private boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}