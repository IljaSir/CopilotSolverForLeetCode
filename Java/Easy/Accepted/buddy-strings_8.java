class Solution {
    public boolean buddyStrings(String s, String goal) {
        
        if (s.length() != goal.length()) {
            return false;
        }
        int diff = 0;
        int[] count = new int[26];
        int first = -1;
        int second = -1;
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            if (s.charAt(i) != goal.charAt(i)) {
                diff++;
                if (first == -1) {
                    first = i;
                } else if (second == -1) {
                    second = i;
                }
            }
        }
        if (diff == 2) {
            return s.charAt(first) == goal.charAt(second) && s.charAt(second) == goal.charAt(first);
        } else if (diff == 0) {
            for (int i = 0; i < 26; i++) {
                if (count[i] > 1) {
                    return true;
                }
            }
        }
        return false;
    }
}