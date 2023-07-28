class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        
        int[] ch1 = new int[26];
        int[] ch2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            ch1[s1.charAt(i) - 'a']++;
            ch2[s2.charAt(i) - 'a']++;
        }

        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < 26; i++) {
            count1 += ch1[i];
            count2 += ch2[i];

            if (count1 >= count2) {
                continue;
            } else {
                count1 = 0;
                count2 = 0;
            }

            count2 += ch1[i];
            count1 += ch2[i];

            if (count1 >= count2) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}