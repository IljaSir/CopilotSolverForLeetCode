class Solution {
    public boolean buddyStrings(String s, String goal) {
        
        if (s.length() != goal.length()) {
            return false;
        }
        int[] count = new int[26];
        int diff = 0;
        int index1 = -1;
        int index2 = -1;
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            if (s.charAt(i) != goal.charAt(i)) {
                diff++;
                if (diff == 1) {
                    index1 = i;
                } else if (diff == 2) {
                    index2 = i;
                } else {
                    return false;
                }
            }
        }
        if (diff == 0) {
            for (int i = 0; i < 26; i++) {
                if (count[i] >= 2) {
                    return true;
                }
            }
            return false;
        }
        if (diff == 1) {
            return false;
        }
        return s.charAt(index1) == goal.charAt(index2) && s.charAt(index2) == goal.charAt(index1);
    }
}