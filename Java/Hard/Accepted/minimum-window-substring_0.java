class Solution {
    public String minWindow(String s, String t) {
        
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, count = t.length(), min = Integer.MAX_VALUE, start = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) >= 0) {
                    count--;
                }
            }
            right++;
            while (count == 0) {
                if (right - left < min) {
                    min = right - left;
                    start = left;
                }
                char d = s.charAt(left);
                if (map.containsKey(d)) {
                    map.put(d, map.get(d) + 1);
                    if (map.get(d) > 0) {
                        count++;
                    }
                }
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }
}