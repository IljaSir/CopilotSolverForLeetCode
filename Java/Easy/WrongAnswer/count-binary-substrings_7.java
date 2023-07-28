class Solution {
    public int countBinarySubstrings(String s) {
        
        int[] count = new int[2];
        int prev = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - '0';
            count[c]++;
            if (prev != c) {
                prev = c;
                count[prev ^ 1] = 0;
            }
            if (count[0] == count[1]) {
                res++;
            }
        }
        return res;
    }
}