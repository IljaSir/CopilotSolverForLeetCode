class Solution {
    public int[] groupStrings(String[] words) {
        
        int[] ans = new int[2];
        int max = 0;
        int maxGroup = 0;
        for (int i = 0; i < words.length; i++) {
            int count = 0;
            boolean[] visited = new boolean[words.length];
            visited[i] = true;
            int group = 1;
            for (int j = 0; j < words.length; j++) {
                if (i == j) continue;
                if (visited[j]) continue;
                if (isConnected(words[i], words[j])) {
                    visited[j] = true;
                    group++;
                }
            }
            if (group > maxGroup) {
                maxGroup = group;
                max = 1;
            } else if (group == maxGroup) {
                max++;
            }
        }
        ans[0] = max;
        ans[1] = maxGroup;
        return ans;
    }
    
    private boolean isConnected(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }
}