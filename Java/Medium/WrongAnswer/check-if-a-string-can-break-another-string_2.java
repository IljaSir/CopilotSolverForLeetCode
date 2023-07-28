class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }
        int diff = 0;
        for (int i = 0; i < 26; i++) {
            diff += count1[i] - count2[i];
            if (diff < 0) {
                for (int j = i + 1; j < 26; j++) {
                    if (count1[j] > 0) {
                        return false;
                    }
                }
            } else if (diff > 0) {
                for (int j = i + 1; j < 26; j++) {
                    if (count2[j] > 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}