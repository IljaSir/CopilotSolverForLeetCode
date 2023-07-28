class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        
        // return 0;
        int max = 0;
        Map<String, Integer> count = new HashMap<>();
        for (int i = 0; i <= s.length() - minSize; i++) {
            String sub = s.substring(i, i + minSize);
            if (count.containsKey(sub)) {
                count.put(sub, count.get(sub) + 1);
            } else {
                Set<Character> letters = new HashSet<>();
                for (char c : sub.toCharArray()) {
                    letters.add(c);
                }
                if (letters.size() <= maxLetters) {
                    count.put(sub, 1);
                }
            }
        }
        for (Map.Entry<String, Integer> e : count.entrySet()) {
            max = Math.max(max, e.getValue());
        }
        return max;
    }
}