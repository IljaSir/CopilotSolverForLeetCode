class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        
        Map<Integer, Integer> freq = new HashMap<>();
        for (String word: words) {
            int mask = 0;
            for (char ch: word.toCharArray())
                mask |= (1 << (ch - 'a'));
            if (Integer.bitCount(mask) <= 7)
                freq.put(mask, freq.getOrDefault(mask, 0) + 1);
        }

        List<Integer> ans = new ArrayList<>();
        for (String puzzle: puzzles) {
            int total = 0;

            // enumerate through all the subsets of the first seven letters
            // of the puzzle
            int mask = 0;
            for (int i = 1; i < 7; ++i)
                mask |= (1 << (puzzle.charAt(i) - 'a'));
            int subset = mask;
            do {
                int s = subset | (1 << (puzzle.charAt(0) - 'a'));
                if (freq.containsKey(s))
                    total += freq.get(s);
                subset = (subset - 1) & mask;
            } while (subset != mask);

            // take the case when none of the first seven letters are in the word
            int s = 1 << (puzzle.charAt(0) - 'a');
            if (freq.containsKey(s))
                total += freq.get(s);

            ans.add(total);
        }

        return ans;
    }
}