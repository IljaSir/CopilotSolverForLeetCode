class Solution {
    public int deleteString(String s) {
        
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        int max = 0;
        for (int count : counts) {
            if (count == 0) {
                continue;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}