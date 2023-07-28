class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }
        boolean canBreak1 = true;
        boolean canBreak2 = true;
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < 26; i++) {
            sum1 += count1[i];
            sum2 += count2[i];
            if (sum1 < sum2) {
                canBreak1 = false;
            }
            if (sum2 < sum1) {
                canBreak2 = false;
            }
        }
        return canBreak1 || canBreak2;
    }
}