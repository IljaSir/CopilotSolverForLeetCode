class Solution {
    public int numberOfSubstrings(String s) {
        
        int[] freq = new int[3];
        int i = 0, j = 0, res = 0;
        for (i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                freq[s.charAt(j) - 'a']--;
                j++;
            }
            res += j;
        }
        return res;
    }
}