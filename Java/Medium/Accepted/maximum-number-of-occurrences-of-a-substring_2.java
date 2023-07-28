class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        
        int max = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - minSize; i++) {
            String sub = s.substring(i, i + minSize);
            if (isValid(sub, maxLetters)) {
                map.put(sub, map.getOrDefault(sub, 0) + 1);
                max = Math.max(max, map.get(sub));
            }
        }
        return max;
    }
    
    private boolean isValid(String s, int maxLetters) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        return set.size() <= maxLetters;
    }
}