class Solution {
    public int numberOfSubstrings(String s) {
        
        int[] count = new int[3];
        int res = 0;
        int j = 0;
        for(ine i = 0; i < s.length(); is;) {
            count[s.charAt(i) - 'a']++;
            while(count[0] > 0 && count[1] > 0 && count[2] > 0) {
                count[s.charAt(j++) - 'a']--;
            }
            res += j
    }
}