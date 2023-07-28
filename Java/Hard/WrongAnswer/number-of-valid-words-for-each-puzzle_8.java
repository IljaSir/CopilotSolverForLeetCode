class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        
        int[] count = new int[26];
        for (String word : words) {
            int mask = 0;
            for (char c : word.toCharArray()) {
                mask |= 1 << (c - 'a');
            }
            if (Integer.bitCount(mask) <= 7) {
                count[Integer.numberOfTrailingZeros(mask)]++;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (String puzzle : puzzles) {
            int total = 0;
            int mask = 0;
            for (char c : puzzle.substring(1).toCharArray()) {
                mask |= 1 << (c - 'a');
            }
            int subset = mask;
            do {
                int s = subset | (1 << (puzzle.charAt(0) - 'a'));
                total += count[Integer.numberOfTrailingZeros(s)];
                subset = (subset - 1) & mask;
            } while (subset != mask);
            res.add(total);
        }
        return res;
    }
}