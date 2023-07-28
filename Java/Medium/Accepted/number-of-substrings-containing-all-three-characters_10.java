class Solution {
    public int numberOfSubstrings(String s) {
        
        int[] count = new int[3];
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < s.length()) {
            count[s.charAt(right) - 'a']++;
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                count[s.charAt(left) - 'a']--;
                left++;
            }
            res += left;
            right++;
        }
        return res;
    }
}