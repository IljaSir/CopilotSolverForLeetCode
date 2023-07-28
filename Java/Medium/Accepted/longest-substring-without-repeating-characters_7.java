class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int[] map = new int[128];
        int max = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            i = Math.max(map[s.charAt(j)], i);
            max = Math.max(max, j - i + 1);
            map[s.charAt(j)] = j + 1;
        }
        return max;
    }
}