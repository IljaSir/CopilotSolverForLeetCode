class Solution {
    public int numSplits(String s) {
        
        Map<Character, Integer> left = new HashMap<>();
        Map<Character, Integer> right = new HashMap<>();
        for (char c : s.toCharArray()) {
            right.put(c, right.getOrDefault(c, 0) + 1);
        }
        int count = 0;
        for (char c : s.toCharArray()) {
            right.put(c, right.getOrDefault(c, 0) - 1);
            if (right.get(c) == 0) {
                right.remove(c);
            }
            left.put(c, left.getOrDefault(c, 0) + 1);
            if (left.size() == right.size()) {
                count++;
            }
        }
        return count;
    }
}