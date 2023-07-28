class Solution {
    public int longestSubstring(String s, int k) {
        
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int i = 0;
        while (i < s.length() && map.get(s.charAt(i)) >= k) {
            i++;
        }
        if (i == s.length()) {
            return s.length();
        }
        int left = longestSubstring(s.substring(0, i), k);
        while (i < s.length() && map.get(s.charAt(i)) < k) {
            i++;
        }
        int right = longestSubstring(s.substring(i), k);
        return Math.max(left, right);
    }
}