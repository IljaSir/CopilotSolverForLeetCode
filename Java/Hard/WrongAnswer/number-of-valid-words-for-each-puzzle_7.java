class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            int mask = 0;
            for (char c : word.toCharArray()) {
                mask |= 1 << (c - 'a');
            }
            wordMap.put(mask, wordMap.getOrDefault(mask, 0) + 1);
        }
        for (String puzzle : puzzles) {
            int mask = 0;
            for (char c : puzzle.toCharArray()) {
                mask |= 1 << (c - 'a');
            }
            int count = 0;
            int sub = mask;
            do {
                int s = sub | 1 << (puzzle.charAt(0) - 'a');
                if (wordMap.containsKey(s)) {
                    count += wordMap.get(s);
                }
                sub = (sub - 1) & mask;
            } while (sub != mask);
            result.add(count);
        }
        return result;
    }
}