class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - minSize; i++) {
            String sub = s.substring(i, i + minSize);
            Set<Character> set = new HashSet<>();
            for (char c : sub.toCharArray()) {
                set.add(c);
            }
            if (set.size() <= maxLetters) {
                map.put(sub, map.getOrDefault(sub, 0) + 1);
            }
        }
        int max = 0;
        for (int v : map.values()) {
            max = Math.max(max, v);
        }
        return max;
    }
}