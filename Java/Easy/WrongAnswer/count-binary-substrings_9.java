class Solution {
    public int countBinarySubstrings(String s) {
        
        int[] count = new int[2];
        int result = 0;
        int prev = -1;
        for (char c : s.toCharArray()) {
            int idx = c - '0';
            if (idx != prev) {
                count[idx] = 0;
                prev = idx;
            }
            count[idx]++;
            if (count[0] == count[1]) {
                result++;
            }
        }
        return result;
    }
}