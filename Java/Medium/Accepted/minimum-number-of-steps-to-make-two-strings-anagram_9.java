class Solution {
    public int minSteps(String s, String t) {
        
        int[] freq = new int[26];
        int steps = 0;
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            if (freq[c - 'a'] > 0) {
                freq[c - 'a']--;
            } else {
                steps++;
            }
        }
        return steps;
    }
}