class Solution {
    public int minSteps(String s, String t) {
        
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                res += count[i];
            }
        }
        return res;
    }
}