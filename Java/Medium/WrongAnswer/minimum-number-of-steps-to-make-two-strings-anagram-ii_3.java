class Solution {
    public int minSteps(String s, String t) {
        
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
        }
        int diff = 0;
        for (int i : count) {
            diff += i > 0 ? i : 0;
        }
        return diff;
    }
}