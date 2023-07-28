class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (char c : s1.toCharArray()) {
            count1[c - 'a']++;
        }
        for (char c : s2.toCharArray()) {
            count2[c - 'a']++;
        }
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < 26; ++i) {
            sum1 += count1[i];
            sum2 += count2[i];
            if (sum1 < sum2) {
                return false;
            }
        }
        sum1 = 0;
        sum2 = 0;
        for (int i = 25; i >= 0; --i) {
            sum1 += count1[i];
            sum2 += count2[i];
            if (sum1 < sum2) {
                return false;
            }
        }
        return true;
    }
}