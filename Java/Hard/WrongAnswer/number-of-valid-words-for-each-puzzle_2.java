class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (String word : words) {
            int mask = 0;
            for (char c : word.toCharArray()) {
                mask |= (1 << (c - 'a'));
            }
            map.put(mask, map.getOrDefault(mask, 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
        for (String puzzle : puzzles) {
            int mask = 0;
            for (char c : puzzle.toCharArray()) {
                mask |= (1 << (c - 'a'));
            }
            int count = 0;
            int subMask = mask;
            while (subMask != 0) {
                int first = subMask & (-subMask);
                if ((first & (1 << (puzzle.charAt(0) - 'a'))) != 0) {
                    count += map.getOrDefault(subMask, 0);
                }
                subMask = (subMask - 1) & mask;
            }
            ans.add(count);
        }
        return ans;
    }
}