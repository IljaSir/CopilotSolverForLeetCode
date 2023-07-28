class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (String word : words) {
            int mask = 0;
            for (char c : word.toCharArray()) {
                mask |= 1 << (c - 'a');
            }
            map.put(mask, map.getOrDefault(mask, 0) + 1);
        }
        for (String puzzle : puzzles) {
            int mask = 0;
            for (char c : puzzle.toCharArray()) {
                mask |= 1 << (c - 'a');
            }
            int sub = mask;
            int count = 0;
            do {
                int s = sub | (1 << (puzzle.charAt(0) - 'a'));
                if (map.containsKey(s)) {
                    count += map.get(s);
                }
                sub = (sub - 1) & mask;
            } while (sub != mask);
            ans.add(count);
        }
        return ans;
    }
}