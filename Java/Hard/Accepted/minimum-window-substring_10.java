class Solution {
    public String minWindow(String s, String t) {
        
        int left = 0;
        int right = 0;
        int minLeft = 0;
        int minRight = 0;
        int minLen = Integer.MAX_VALUE;
        int count = 0;
        int[] map = new int[128];
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]++;
        }
        while (right < s.length()) {
            if (map[s.charAt(right)] > 0) {
                count++;
            }
            map[s.charAt(right)]--;
            right++;
            while (count == t.length()) {
                if (right - left < minLen) {
                    minLen = right - left;
                    minLeft = left;
                    minRight = right;
                }
                if (map[s.charAt(left)] == 0) {
                    count--;
                }
                map[s.charAt(left)]++;
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minRight);
    }
}