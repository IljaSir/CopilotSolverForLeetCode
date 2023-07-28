class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> frequency = new HashMap<>();
        for (String word : words) {
            int mask = 0;
            for (char ch : word.toCharArray()) {
                mask |= (1 << (ch - 'a'));
            }
            if (Integer.bitCount(mask) <= 7) {
                frequency.put(mask, frequency.getOrDefault(mask, 0) + 1);
            }
        }
        for (String puzzle : puzzles) {
            int total = 0;
            for (int choose = 0; choose < (1 << 6); choose++) {
                int mask = 0;
                for (int i = 0; i < 6; i++) {
                    if ((choose & (1 << i)) != 0) {
                        mask |= (1 << (puzzle.charAt(i + 1) - 'a'));
                    }
                }
                mask |= (1 << (puzzle.charAt(0) - 'a'));
                if (frequency.containsKey(mask)) {
                    total += frequency.get(mask);
                }
            }
            result.add(total);
        }
        return result;
    }
}