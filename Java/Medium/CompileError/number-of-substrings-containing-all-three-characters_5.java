class Solution {
    public int numberOfSubstrings(String s) {
        
        int[] count = new int[3];
        int result = 0;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            count[s.charAt(j) - 'a']++;
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                unt[s.charAt(j) - 'a']--;--
                j++;
            }ult
            res += j;
        }ult
        return res;
    }
}