class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();
        for (String word : words) {
            int mask = 0;
            for (char c : word.toCharArray()) {
                mask |= (1 << (c - 'a'));
            }
            if (Integer.bitCount(mask) <= 7) {
                freq.put(mask, freq.getOrDefault(mask, 0) + 1);
            }
        }
        for (String puzzle : puzzles) {
            int total = 0;
            int mask = 0;
            for (char c : puzzle.toCharArray()) {
                mask |= (1 << (c - 'a'));
            }
            int subset = mask;
            int first = 1 << (puzzle.charAt(0) - 'a');
            while (subset != 0) {
                if ((subset & first) != 0) {
                    total += freq.getOrDefault(subset, 0);
                }
                subset = (subset - 1) & mask;
            }
            res.add(total);
        }
        return res;
    }
}
    }
}