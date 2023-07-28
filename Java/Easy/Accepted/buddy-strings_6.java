class Solution {
    public boolean buddyStrings(String s, String goal) {
        
        if (s.length() != goal.length()) {
            return false;
        }
        int[] count = new int[26];
        int diff = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                diff++;
            }
            count[s.charAt(i) - 'a']++;
        }
        if (diff == 0) {
            for (int i = 0; i < count.length; i++) {
                if (count[i] >= 2) {
                    return true;
                }
            }
        }
        if (diff == 2) {
            int i = 0;
            while (s.charAt(i) == goal.charAt(i)) {
                i++;
            }
            int j = i + 1;
            while (s.charAt(j) == goal.charAt(j)) {
                j++;
            }
            return s.charAt(i) == goal.charAt(j) && s.charAt(j) == goal.charAt(i);
        }
        return false;
    }
}