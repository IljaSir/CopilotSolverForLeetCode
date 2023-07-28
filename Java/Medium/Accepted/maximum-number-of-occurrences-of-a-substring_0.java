class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() - minSize + 1; i++) {
            String sub = s.substring(i, i + minSize);
            if (check(sub, maxLetters)) {
                map.put(sub, map.getOrDefault(sub, 0) + 1);
            }
        }
        int max = 0;
        for (String key : map.keySet()) {
            max = Math.max(max, map.get(key));
        }
        return max;
    }
    private boolean check(String sub, int maxLetters) {
        Set<Character> set = new HashSet<>();
        for (char c : sub.toCharArray()) {
            set.add(c);
        }
        return set.size() <= maxLetters;
    }
}