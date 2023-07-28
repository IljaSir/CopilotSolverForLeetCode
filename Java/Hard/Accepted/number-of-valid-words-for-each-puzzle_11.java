class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        
        List<Integer> res = new ArrayList<>();
        if (words.length == 0 || puzzles.length == 0) return res;
        Map<Integer, Integer> map = new HashMap<>();
        for (String word : words) {
            int mask = 0;
            for (char c : word.toCharArray()) {
                mask |= 1 << (c - 'a');
            }
            map.put(mask, map.getOrDefault(mask, 0) + 1);
        }
        for (String puzzle : puzzles) {
            int total = 0;
            int mask = 0;
            for (char c : puzzle.toCharArray()) {
                mask |= 1 << (c - 'a');
            }
            int subset = mask;
            int first = 1 << (puzzle.charAt(0) - 'a');
            while (subset != 0) {
                if ((subset & first) != 0) {
                    total += map.getOrDefault(subset, 0);
                }
                subset = (subset - 1) & mask;
            }
            res.add(total);
        }
        return res;
    }
}