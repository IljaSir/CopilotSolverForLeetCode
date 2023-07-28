class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) {
            return false;
        }
        for (int i = 0; i < len1; i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }
        for (int i = len1; i < len2; i++) {
            if (check(s1Count, s2Count)) {
                return true;
            }
            s2Count[s2.charAt(i) - 'a']++;
            s2Count[s2.charAt(i - len1) - 'a']--;
        }
        return check(s1Count, s2Count);
    }
    private boolean check(int[] s1Count, int[] s2Count) {
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] != s2Count[i]) {
                return false;
            }
        }
        return true;
    }
}