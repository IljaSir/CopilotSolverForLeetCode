class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int n = s1.length();
        int m = s2.length();
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        if (allZero(count)) return true;
        for (int i = n; i < m; i++) {
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - n) - 'a']++;
            if (allZero(count)) return true;
        }
        return false;
    }
    private boolean allZero(int[] count) {
        for (int i : count) {
            if (i != 0) return false;
        }
        return true;
    }
}