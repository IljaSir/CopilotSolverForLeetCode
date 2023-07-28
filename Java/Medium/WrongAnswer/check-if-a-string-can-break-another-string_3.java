class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            count += count1[i] - count2[i];
            if (count > 0) {
                return false;
            }
        }
        count = 0;
        for (int i = 0; i < 26; i++) {
            count += count2[i] - count1[i];
            if (count > 0) {
                return false;
            }
        }
        return true;
    }
}