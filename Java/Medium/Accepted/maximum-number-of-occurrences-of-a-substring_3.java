class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        
        int res = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - minSize; i++) {
            String sub = s.substring(i, i + minSize);
            HashSet<Character> set = new HashSet<>();
            for (char c : sub.toCharArray()) {
                set.add(c);
            }
            if (set.size() <= maxLetters) {
                map.put(sub, map.getOrDefault(sub, 0) + 1);
                res = Math.max(res, map.get(sub));
            }
        }
        return res;
    }
}