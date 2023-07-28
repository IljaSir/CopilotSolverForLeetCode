class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }
        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < 26; i++) {
            c1 += count1[i];
            c2 += count2[i];
            if (c1 < c2) {
                return false;
            }
        }
        c1 = 0;
        c2 = 0;
        for (int i = 25; i >= 0; i--) {
            c1 += count1[i];
            c2 += count2[i];
            if (c2 < c1) {
                return false;
            }
        }
        return true;
    }
}